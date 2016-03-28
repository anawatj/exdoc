package com.tao.exdoc.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Component
public class HibernateAwareMapper extends ObjectMapper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HibernateAwareMapper() {
		registerModule(new Hibernate4Module());
		setLocale(Locale.ENGLISH);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss");
		setDateFormat(df);
	}
}
