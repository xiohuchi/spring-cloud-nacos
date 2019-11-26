

package com.nacos.ehr.common.gateway.configuration;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Mica ribbon rule auto configuration.
 *
 * @author L.cm
 * @link https://github.com/lets-mica/mica
 */
@Configuration
@RequiredArgsConstructor
@ConditionalOnClass(NacosServer.class)
@AutoConfigureBefore(RibbonClientConfiguration.class)
@ConditionalOnProperty(value = "ribbon.rule.enabled", matchIfMissing = true)
public class EhrRibbonRuleAutoConfiguration {


}
