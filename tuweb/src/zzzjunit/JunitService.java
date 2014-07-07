package zzzjunit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.User;

import com.toto.www.service.owner.LoginService;

public class JunitService {
	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void initPro(){
		System.out.println("初始环境");
		ctx = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring/applicationContext.xml","classpath*:spring/spring-*.xml"});
	}
	
	@AfterClass
	public static void destoryPro(){
		System.out.println("释放环境");
	}
	
	@Before
	public void beforeMethod(){
		System.out.println("方法前");
	}
	
	@After
	public void afteryMethod(){
		System.out.println("方法后");
	}
	
	
	@Test
	public void testLogin(){
		LoginService login = (LoginService)ctx.getBean("loginService");
		User user = new User();
		user.setLoginName("caolc");
		user.setLoginPws("111");
		user = login.findUser(user);
		assertNotNull(user);
	}
	 
	
	
	
	
}
