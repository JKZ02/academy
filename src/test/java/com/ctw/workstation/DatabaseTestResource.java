/*
package com.ctw.workstation;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

public class DatabaseTestResource implements QuarkusTestResourceLifecycleManager {

    PostgreSQLContainer postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:12.19"));;

    @Override
    public Map<String, String> start() {
        */
/*postgres.withDatabaseName("fs_academy")
                .withPassword("postgres")
                .withUsername("postgres")
                .withExposedPorts(5432)
                .start();
        return Map.of();*//*


        Log.infof("About to start", "DatabaseTestResource");

        postgres.withDatabaseName("fs_academy")
                .withExposedPorts(5432)
                .start();

        return Map.of(
                "quarkus.log.console.json", "false",
                "quarkus.datasource.username", postgres.getUsername(),
                "quarkus.datasource.password", postgres.getPassword(),
                "quarkus.datasource.jdbc.url", postgres.getJdbcUrl()
        );
    }

    @Override
    public void stop() {
        postgres.stop();
    }
}
*/
