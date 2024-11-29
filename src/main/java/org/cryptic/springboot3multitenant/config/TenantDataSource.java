package org.cryptic.springboot3multitenant.config;

import jakarta.annotation.PostConstruct;
import org.cryptic.springboot3multitenant.entity.DataSourceConfig;
import org.cryptic.springboot3multitenant.repository.DataSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TenantDataSource implements Serializable {

    private HashMap<String, javax.sql.DataSource> dataSources = new HashMap<>();

    @Autowired
    private DataSourceRepository dataSourceConfigRepository;

    public javax.sql.DataSource getDataSource(String name) {
        if (dataSources.get(name) != null) {
            return dataSources.get(name);
        }
        javax.sql.DataSource dataSource = createDataSource(name);
        if (dataSource != null) {
            dataSources.put(name, dataSource);
        }
        return dataSource;
    }

    @PostConstruct
    public Map<String, javax.sql.DataSource> getAll() {
        List<DataSourceConfig> configList = dataSourceConfigRepository.findAll();
        Map<String, javax.sql.DataSource> result = new HashMap<>();
        for (DataSourceConfig config : configList) {
            javax.sql.DataSource dataSource = getDataSource(config.getName());
            result.put(config.getName(), dataSource);
        }
        return result;
    }

    private javax.sql.DataSource createDataSource(String name) {
        DataSourceConfig config = dataSourceConfigRepository.findByName(name);
        if (config != null) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrl());
            javax.sql.DataSource ds = factory.build();
            return ds;
        }
        return null;
    }

}
