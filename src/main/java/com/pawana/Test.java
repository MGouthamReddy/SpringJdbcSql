package com.pawana;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(Appconfig.class);
		JdbcTemplate   j=(JdbcTemplate) ac.getBean("jobj");
		String sql="insert into gf values(?,?,?)";
		int count  =j.update(sql,2,"B",30);
		System.out.println(count);
	}

}
