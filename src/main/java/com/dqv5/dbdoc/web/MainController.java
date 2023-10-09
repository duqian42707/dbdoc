package com.dqv5.dbdoc.web;

import com.dqv5.dbdoc.pojo.DbdocConfigDTO;
import com.dqv5.dbdoc.pojo.GenerateResult;
import com.dqv5.dbdoc.service.MainService;
import com.dqv5.dbdoc.util.JsonUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;

/**
 * @author duqian
 * @date 2023/9/11
 */
@RestController
@RequestMapping("/api")
public class MainController {
    @Resource
    private MainService mainService;


    @GetMapping("/download-templates")
    public ResponseEntity<InputStreamResource> downloadTemplates(HttpServletResponse response) throws IOException {
        String fileName = "templates.zip";
        ClassPathResource classPathResource = new ClassPathResource("files/" + fileName);
        InputStream inputStream = classPathResource.getInputStream();
        InputStreamResource resource = new InputStreamResource(inputStream);

        HttpHeaders headers = new HttpHeaders();
        String filename = URLEncoder.encode(fileName, "UTF-8");
        headers.add("Content-Disposition", String.format("attachment;filename=%s", filename));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(inputStream.available())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


    @PostMapping("/generate")
    public void generate(@RequestParam String json, @RequestParam(required = false) MultipartFile template, HttpServletResponse response) {
        DbdocConfigDTO param = JsonUtil.readValue(json, DbdocConfigDTO.class);
        GenerateResult result = mainService.generate(param, template);
        String folderName = result.getFolderName();
        File file = result.getFile();

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = Files.newInputStream(file.toPath());
            outputStream = response.getOutputStream();

            String filename = URLEncoder.encode(file.getName(), "UTF-8");
            response.setHeader("Content-Disposition", String.format("attachment;filename=%s", filename));
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
            response.setContentLength(inputStream.available());
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

            IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(inputStream);
            mainService.deleteTempFolder(folderName);
        }
    }
}
