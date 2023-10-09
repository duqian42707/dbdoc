package com.dqv5.dbdoc.service;

import com.dqv5.dbdoc.pojo.DbdocConfigDTO;
import com.dqv5.dbdoc.pojo.GenerateResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author duqian
 * @date 2020/7/22
 */

public interface MainService {
    /**
     * 生成文件并下载
     */
    GenerateResult generate(DbdocConfigDTO param, MultipartFile template);

    void deleteTempFolder(String folderName);

}
