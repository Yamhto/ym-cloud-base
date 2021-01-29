package com.yamhto.cloud.mybatis.plus;

import com.yamhto.cloud.mybatis.plus.core.DataSourceProperties;
import com.yamhto.cloud.mybatis.plus.core.JdbcDynamicDataSourceProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述：
 *
 * @ClassName DynamicDataSourceConfiguration
 * @Description 动态数据源配置
 * @Author ming.yang
 * @Date 2021/1/29 4:06 下午
 * @Version 1.0
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties(DataSourceProperties.class)
public class DynamicDataSourceConfiguration {

    private final DataSourceProperties properties;

    DynamicDataSourceConfiguration(DataSourceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public JdbcDynamicDataSourceProvider DynamicDataSourceProvider() {
        return new JdbcDynamicDataSourceProvider(properties);
    }
}
