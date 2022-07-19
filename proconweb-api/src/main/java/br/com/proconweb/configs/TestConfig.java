package br.com.proconweb.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.proconweb.services.DBService;

/**
 * 
 * @author Marlon F. Garcia
 *
 */
@Configuration
@Profile("dev")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	boolean instatiateDatabase() {
		this.dbService.initDatabase();
		return true;
	}

}
