

package com.nacos.ehr.common.gateway.support;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import com.nacos.ehr.common.gateway.vo.RouteDefinitionVo;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangbin
 * @date 2019年09月04日
 * <p>
 * 路由缓存工具类
 */
@UtilityClass
public class RouteCacheHolder {
    private Cache<String, RouteDefinitionVo> cache = CacheUtil.newLFUCache(50);

    /**
     * 获取缓存的全部对象
     *
     * @return routeList
     */
    public List<RouteDefinitionVo> getRouteList() {
        List<RouteDefinitionVo> routeList = new ArrayList<>();
        cache.forEach(route -> routeList.add(route));
        return routeList;
    }

    /**
     * 更新缓存
     *
     * @param routeList 缓存列表
     */
    public void setRouteList(List<RouteDefinitionVo> routeList) {
        routeList.forEach(route -> cache.put(route.getId(), route));
    }

    /**
     * 清空缓存
     */
    public void removeRouteList() {
        cache.clear();
    }

}
