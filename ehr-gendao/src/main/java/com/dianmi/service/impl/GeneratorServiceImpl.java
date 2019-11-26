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

        List<String> tableNameList = Arrays.asList("WORKER_NODE", "base_enum", "t_access_token_record", "t_app_state", "t_company_info", "t_course",
                "t_course_cw", "t_course_group", "t_course_group_relation", "t_course_lecturer", "t_courseware",
                "t_courseware_download_record", "t_courseware_group", "t_courseware_view", "t_department", "t_file_image",
                "t_lecturer", "t_lecturer_train_record", "t_member_courseware_score", "t_scene_info", "t_student_group",
                "t_student_group_intelligent_manage", "t_student_group_member", "t_train_category", "t_train_course",
                "t_train_form", "t_train_invite_join_member", "t_train_member_record", "t_train_notice_lecturer_record",
                "t_train_notice_member_record", "t_train_notice_setting", "t_train_online_course_setting", "t_train_plan",
                "t_train_plan_img", "t_train_plan_member", "t_train_sign_record", "t_train_signed_setting", "t_train_signup_setting",
                "t_train_student_group", "t_use_statistics", "t_usr_info");
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
