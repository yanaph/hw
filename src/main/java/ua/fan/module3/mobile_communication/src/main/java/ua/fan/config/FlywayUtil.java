package ua.fan.config;

import org.flywaydb.core.Flyway;

public class FlywayUtil {
    public void migrate(){
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/mobile_communications", "postgres", "root")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();
    }
}
