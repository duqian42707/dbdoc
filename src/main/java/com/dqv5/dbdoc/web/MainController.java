package com.dqv5.dbdoc.web;

import com.dqv5.dbdoc.pojo.DbdocConfigDTO;
import com.dqv5.dbdoc.service.MainService;
import com.dqv5.dbdoc.util.JsonUtil;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
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

    @PostMapping("/generate")
    public ResponseEntity<InputStreamResource> generate(@RequestParam String json, @RequestParam(required = false) MultipartFile template) throws IOException {
        DbdocConfigDTO param = JsonUtil.readValue(json, DbdocConfigDTO.class);
        File file = mainService.generate(param, template);
        InputStreamResource resource = new InputStreamResource(Files.newInputStream(file.toPath()));

        HttpHeaders headers = new HttpHeaders();
        String filename = URLEncoder.encode(file.getName(), "UTF-8");
        headers.add("Content-Disposition", String.format("attachment;filename=%s", filename));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
