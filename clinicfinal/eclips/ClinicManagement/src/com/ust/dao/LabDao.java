package com.ust.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class LabDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
