package com.easypoi.util;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Excel导入工具类
 * @author brb
 * @date 2020年08月29日
 */
@Component
public class ExcelImportUtils {

    /**
     * 从指定位置获取文件后进行导入
     * @param filePath
     * @param titleRows
     * @param headerRows
     * @param pojoClass
     * @param <T>
     * @return
     */
    public <T> List<T> importExcel(String filePath, Integer titleRows,
                                   Integer headerRows, Class<?> pojoClass) {

        if (Strings.isEmpty(filePath)) {
            return null;
        } else {
            final ImportParams params = new ImportParams();
            //表格标题行数，默认0
            params.setTitleRows(titleRows);
            //表头行数，默认1
            params.setHeadRows(headerRows);
            //是否需要保存上传的Excel
            params.setNeedSave(true);
            //保存上传的Excel目录
            params.setSaveUrl("/excel/");

            return ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        }
    }

    /**
     * 上传文件导入
     * @param file
     * @param titleRows 标题行
     * @param headerRows    表头行
     * @param needVerfiy    是否检验excel内容
     * @param pojoClass 导入的对象
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> importExcel(MultipartFile file, Integer titleRows,
                                   Integer headerRows, boolean needVerfiy,
                                   Class<T> pojoClass) throws Exception {
        if (file == null) {
            return null;
        } else {
            return baseImport(file.getInputStream(), titleRows,
                    headerRows, needVerfiy, pojoClass);
        }
    }

    /**
     * 最基础导入
     * @param inputStream
     * @param titleRows
     * @param headerRows
     * @param needVerfiy
     * @param pojoClass
     * @param <T>
     * @return
     */
    private <T> List<T> baseImport(InputStream inputStream,
                                   Integer titleRows, Integer headerRows,
                                   boolean needVerfiy, Class<T> pojoClass) throws Exception {

        if (inputStream == null) {
            return null;
        } else {
            final ImportParams params = new ImportParams();
            params.setTitleRows(titleRows);
            params.setHeadRows(headerRows);
            params.setSaveUrl("/excel/");
            params.setNeedSave(true);
            params.setNeedVerify(needVerfiy);

            return ExcelImportUtil.importExcel(inputStream, pojoClass, params);
        }
    }


}
