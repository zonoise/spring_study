package demo;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

import java.net.URI;
import java.net.URISyntaxException;


//http://yuya4wd-startpg.hatenablog.com/entry/2015/01/23/%E3%80%90Springboot%E3%80%91Heroku%E3%81%B8%E3%83%87%E3%83%97%E3%83%AD%E3%82%A4%E3%81%97%E3%81%A6%E3%81%BF%E3%82%8B
//http://altfatterz.blogspot.jp/2014/10/datasource-configuration-with-spring.html

@Configuration
@Profile("heroku")
public class AppConfig {
    @Autowired
    DataSourceProperties properties;
    DataSource dataSource;

    @Bean(destroyMethod = "close")
    DataSource realDataSource() throws URISyntaxException {
        String url;
        String username;
        String password;

        String databaseUrl = System.getenv("DATABASE_URL");
        if (databaseUrl != null) {
            //heroku側
            URI dbUri = new URI(databaseUrl);
            url = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath() + ":" + dbUri.getPort() + dbUri.getPath();
            username = dbUri.getUserInfo().split(":")[0];
            password = dbUri.getUserInfo().split(":")[1];
        } else {
            //localhost側
            url = this.properties.getUrl();
            username = this.properties.getUsername();
            password = this.properties.getPassword();
        }

        DataSourceBuilder factory = DataSourceBuilder
                .create(this.properties.getClassLoader())
                .url(url)
                .username(username)
                .password(password);
        this.dataSource = factory.build();
        return this.dataSource;
    }

    @Bean
    DataSource dataSource() {
        return new Log4jdbcProxyDataSource(this.dataSource);
    }
}