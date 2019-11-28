package com.dianmi.service.impl;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dianmi.entity.GenConfig;
import com.dianmi.entity.GenFormConf;
import com.dianmi.mapper.GenFormConfMapper;
import com.dianmi.mapper.GeneratorMapper;
import com.dianmi.service.GeneratorService;
import com.dianmi.util.GenUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @author yangbin
 * @date 2018-07-30
 * <p>
 * 代码生成器
 */
@Service
@AllArgsConstructor
public class GeneratorServiceImpl implements GeneratorService {
    private final GeneratorMapper generatorMapper;
    private final GenFormConfMapper genFormConfMapper;

    /**
     * 分页查询表
     *
     * @param tableName 查询条件
     * @param id
     * @return
     */
    @Override
    public IPage<List<Map<String, Object>>> getPage(Page page, String tableName, Integer id) {
        return generatorMapper.queryList(page, tableName);
    }

    /**
     * 生成代码
     *
     * @param genConfig 生成配置
     * @return
     */
    @Override
    public byte[] generatorCode(GenConfig genConfig) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        List<String> tableNameList = Arrays.asList("sys_app_info",
                "sys_authority",
                "sys_dict",
                "sys_dict_item",
                "sys_erhao_secret",
                "sys_group",
                "sys_group_permission",
                "sys_log",
                "sys_operation",
                "sys_permission",
                "sys_role",
                "sys_role_authority",
                "sys_service",
                "sys_user",
                "sys_user_app_info",
                "sys_user_group",
                "sys_user_permission",
                "sys_user_role");
        for (String tableName : tableNameList) {
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //查询表信息
            Map<String, String> table = queryTable(tableName);

            GenFormConf genFormConf = new GenFormConf();
            //生成代码
            GenUtils.generatorCode(genConfig, table, columns, zip, null);
        }
        IoUtil.close(zip);
        return outputStream.toByteArray();
    }

    private Map<String, String> queryTable(String tableName) {
        return generatorMapper.queryTable(tableName);
    }

    private List<Map<String, String>> queryColumns(String tableName) {
        return generatorMapper.queryColumns(tableName);
    }
}
