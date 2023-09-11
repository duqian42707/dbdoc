package com.dqv5.dbdoc.service;

import com.dqv5.dbdoc.pojo.DbdocConfigDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author duqian
 * @date 2020/7/22
 */

public interface MainService {
    /**
     * 生成文件并下载
     */
    File generate(DbdocConfigDTO param, MultipartFile template);

}
