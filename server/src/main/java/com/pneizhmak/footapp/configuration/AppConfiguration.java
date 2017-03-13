package com.pneizhmak.footapp.configuration;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * @author Pavel Neizhmak
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.pneizhmak.footapp")
@EnableJpaRepositories("com.pneizhmak.footapp.db.repository")
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    private final Environment env;

    @Autowired
    public AppConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public DriverManagerDataSource dataSource() {

        final String dbUrl = env.getRequiredProperty("db.url");
        final String dbUser = env.getRequiredProperty("db.username");
        final String dbPass = env.getRequiredProperty("db.password");
        final String dbDriver = env.getRequiredProperty("db.driver");

        DriverManagerDataSource dataSource = new DriverManagerDataSource(dbUrl, dbUser, dbPass);
        dataSource.setDriverClassName(dbDriver);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final String pckgToScan = env.getRequiredProperty("entitymanager.packageToScan");
        final String hibernateDialect = env.getRequiredProperty("hibernate.dialect");
        final String hibernateShowSql = env.getRequiredProperty("hibernate.show_sql");
        final String hibernateHbm2Ddl = env.getRequiredProperty("hibernate.hbm2ddl.auto");


        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(pckgToScan);

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", hibernateDialect);
        jpaProperties.put("hibernate.show_sql", hibernateShowSql);
        jpaProperties.put("hibernate.hbm2ddl.auto", hibernateHbm2Ddl);
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }
}
