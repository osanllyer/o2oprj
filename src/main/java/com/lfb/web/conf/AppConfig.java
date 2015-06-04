package com.lfb.web.conf;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value="com.lfb")
@PropertySources({
	@PropertySource("classpath:app.properties"),
	@PropertySource("classpath:db.properties"),
	@PropertySource("classpath:search.properties")
})
@EnableJpaRepositories("com.lfb.persist")
@EnableTransactionManagement
public class AppConfig{
	
	@Resource
    private Environment env;
	
	public AppConfig() {
	}
	
	
	@Bean
	public Object testEnv(){
		System.out.println("env: {}" + env.toString()); 
		return new Object();
	}
	
	/**
	 * must be staic, or else env will be null!
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public DataSource dataSource(){
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		return builder.setType(EmbeddedDatabaseType.HSQL).build();
		
		BasicDataSource dataSource = new BasicDataSource(); 
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName")); 
		dataSource.setUrl(env.getProperty("jdbc.url")); 
		dataSource.setUsername(env.getProperty("jdbc.username")); 
		dataSource.setPassword(env.getProperty("jdbc.password")); 
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.lfb");
		factory.setDataSource(dataSource());
		factory.setJpaProperties(getJpaProperties());		
		factory.afterPropertiesSet();

		return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	
	public Properties getJpaProperties() {
	        return new Properties() {
	            {
	                setProperty("hibernate.hbm2ddl.auto", "update");
	                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	                setProperty("hibernate.show_sql", "true");
	                setProperty("hibernate.format_sql", "true");
	                setProperty("hibernate.use_sql_comments", "true");
	            }
	        };
	    }	
}
