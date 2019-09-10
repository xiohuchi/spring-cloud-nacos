package com.nacos.ehr.common.datasource.config;

import com.nacos.ehr.common.datasource.support.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author yangbin
 * @date 2019年09月06日
 * <p>
 * 动态数据源类
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 指定路由Key
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}