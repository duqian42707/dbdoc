package com.dqv5.dbdoc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;

/**
 * @author duqian
 * @date 2023/10/9
 */
@Data
@AllArgsConstructor
public class GenerateResult {
    private String folderName;
    private File file;

}
