package hr.kingict.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * A class that configures the data source for application's data access layer
 */
public class PersistenceConfiguration {

    /**
     * A method which creates the data source needed to run the app
     * based on given application properties
     * @return a DataSource object which will be used by the app in order to access the database
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

}
