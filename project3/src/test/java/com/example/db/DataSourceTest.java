package com.example.db;

import static org.junit.Assert.fail;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/root-context.xml") //1.xml 설정
@ContextConfiguration(classes= {RootConfig.class})//2. java설정사용

@Log4j
public class DataSourceTest {
   
   @Setter(onMethod_ = {@Autowired})
   private DataSource dataSource;
   
   @Setter(onMethod_ = { @Autowired })
   private SqlSessionFactory sqlSessionFactory;
   
   @Test
   public void testMyBatis() {
	   try (SqlSession session = sqlSessionFactory.openSession();
			   Connection con = session.getConnection();
			   ) {
		   log.info(session);
		   log.info(con);
	   } catch (Exception e) {
		   fail(e.getMessage());
	   }
   }
   
   @Test
   public void testConncetion()
   {
      try (Connection con = dataSource.getConnection())
      {
         log.info(con);
      }
      catch (Exception e) {
         fail(e.getMessage());
      }
   }
}