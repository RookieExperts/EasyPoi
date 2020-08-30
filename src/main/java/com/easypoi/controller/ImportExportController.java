package com.easypoi.controller;


import com.easypoi.domain.UserDomain;
import com.easypoi.dozer.DozerBeanMapperWrapper;
import com.easypoi.service.UserService;
import com.easypoi.util.ExcelExportUtils;
import com.easypoi.util.ExcelImportUtils;
import com.easypoi.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * excel导出导出
 * @author brb
 * @date 2020年08月30日
 */
@Api(tags = { "APP服务： 数据接口"})
@RestController
@RequestMapping("view/ie")
public class ImportExportController {

    @Autowired
    private ExcelExportUtils excelExportUtils;

    @Autowired
    private ExcelImportUtils excelImportUtils;


    @Autowired
    private DozerBeanMapperWrapper dozerBeanMapper;

    @Autowired
    private UserService userService;

    /**
     * 导出用户信息
     * @throws IOException
     */
    @ApiOperation(value = "导出excel")
    @GetMapping(value = "/exportExcel")
    public void exportExcel() throws IOException {
        //NumberFormat nf = NumberFormat.getNumberInstance()
        final List<UserDomain> userDomainList = userService.list();
        final List<UserVo> userList = dozerBeanMapper.mapperList(userDomainList, UserVo.class);
        excelExportUtils.exportExcel(userList, UserVo.class, "用户信息", "员工信息的sheet", "用户信息表");
    }

    /**
     * 导入用户信息
     * @param file
     * @return
     */
    @ApiOperation(value = "导入excel")
    @GetMapping(value = "/importExcel")
    public void importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        final List<UserVo> userList = excelImportUtils.importExcel(file, 1, 1, false, UserVo.class);
        final List<UserDomain> userDomainList = dozerBeanMapper.mapperList(userList, UserDomain.class);
        userService.saveBatch(userDomainList);
        System.out.println(userList.toString());
        System.out.println("----------");
        System.out.println(userDomainList);
    }
}
