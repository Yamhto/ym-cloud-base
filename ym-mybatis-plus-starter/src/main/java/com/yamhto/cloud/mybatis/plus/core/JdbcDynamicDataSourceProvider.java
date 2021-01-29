package com.yamhto.cloud.mybatis.plus.core;

import com.baomidou.dynamic.datasource.provider.AbstractJdbcDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：
 *
 * @ClassName mysqlDynamicDataSourceProvider
 * @Description 自定义数据源
 * @Author ming.yang
 * @Date 2021/1/29 11:41 上午
 * @Version 1.0
 */
public class JdbcDynamicDataSourceProvider extends AbstractJdbcDataSourceProvider {

    private final DataSourceProperties properties;

    public JdbcDynamicDataSourceProvider(DataSourceProperties properties) {
        super(properties.getDriverClassName(), properties.getUrl(), properties.getUsername(), properties.getPassword());
        this.properties = properties;
    }

    @Override
    protected Map<String, DataSourceProperty> executeStmt(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery(properties.getQueryDsSql());

        Map<String, DataSourceProperty> map = new HashMap<>(8);
        while (rs.next()) {
            String name = rs.getString(DataSourceConstants.DS_NAME);
            String username = rs.getString(DataSourceConstants.DS_USER_NAME);
            String password = rs.getString(DataSourceConstants.DS_USER_PWD);
            String url = rs.getString(DataSourceConstants.DS_JDBC_URL);
            DataSourceProperty property = new DataSourceProperty();
            property.setDriverClassName(DataSourceConstants.DS_DRIVER);
            property.setUsername(username);
            property.setPassword(password);
            property.setUrl(url);
            map.put(name, property);
        }

        // 添加默认主数据源
        DataSourceProperty property = new DataSourceProperty();
        property.setUsername(properties.getUsername());
        property.setPassword(properties.getPassword());
        property.setUrl(properties.getUrl());
        property.setDriverClassName(DataSourceConstants.DS_DRIVER);
        map.put(DataSourceConstants.DS_MASTER, property);
        return map;
    }
}
