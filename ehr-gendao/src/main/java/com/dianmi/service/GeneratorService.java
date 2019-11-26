package com.dianmi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dianmi.entity.GenConfig;

import java.util.List;
import java.util.Map;

/**
 * @author yangbin
 * @date 2018/7/29
 */
public interface GeneratorService {
    /**
     * 生成代码
     *
     * @param tableNames 表名称
     * @return
     */
    byte[] generatorCode(GenConfig tableNames);

    /**
     * 分页查询表
     *
     * @param page      分页信息
     * @param tableName 表名
     * @param id        数据源ID
     * @return
     */
    IPage<List<Map<String, Object>>> getPage(Page page, String tableName, Integer id);
}
