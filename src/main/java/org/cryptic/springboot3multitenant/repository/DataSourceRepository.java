package org.cryptic.springboot3multitenant.repository;

import org.cryptic.springboot3multitenant.entity.DataSourceConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSourceConfig, Long> {
    DataSourceConfig findByName(String name);
}
