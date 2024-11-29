
# Spring Boot 3 Multi Tenant

### Script to insert DataSource
 ```bash
INSERT INTO public.data_source_config
(id, driver_class_name, initialize, name, password, url, username)
VALUES(1, 'org.postgresql.Driver', true, 'tenant1', 'postgresql', 'jdbc:postgresql://localhost:5432/spring-boot-3-multi_tenant', 'postgresql');
```
