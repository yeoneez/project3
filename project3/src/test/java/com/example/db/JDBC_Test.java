package com.example.db;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import lombok.extern.log4j.Log4j;

@Log4j

public class JDBC_Test {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##madang","c##madang")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}