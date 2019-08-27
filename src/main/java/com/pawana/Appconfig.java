package com.pawana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@PropertySource ("Jdbc.properties")
@Configuration 
public class Appconfig {
 @Autowired
	private Environment env;
	@Bean
	public DriverManagerDataSource dobj() {
		DriverManagerDataSource dd=new  DriverManagerDataSource();
		dd.setDriverClassName(env.getProperty("dc"));
		dd.setUrl(env.getProperty("url"));
		dd.setUsername(env.getProperty("un"));
		dd.setPassword(env.getProperty("pwd"));

		return dd;
	}
@Bean
	public JdbcTemplate jobj() {
		JdbcTemplate  jt=new JdbcTemplate();
		jt.setDataSource( dobj());
		return jt;
	}
}