package com.mari.sample01.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleControllerTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void di() throws SQLException{
        Connection connection = dataSource.getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println(databaseMetaData.getURL());
        System.out.println(databaseMetaData.getUserName());
        System.out.println(databaseMetaData.getDriverName());
	}
}
