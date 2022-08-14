package com.itheima.test;

import com.itheima.config.TestBean;
import com.itheima.cyclic.TestService1;
import com.itheima.cyclic.TestService1_constructor;
import com.itheima.cyclic.TestService2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {

	/* 	   问题1：如何创建的BeanFactory(真实类型是什么)？
		   问题2：如何解析的配置文件，封装的BeanDefation

		   ---
		   问题3：验证IOC流程
		   问题4：Bean的生命周期
		   问题5：什么是循环依赖？怎么解决循环依赖【面试题】

			BeanFactoryPostProcessor执行流程
		 */
	public static void main(String[] args) {
		/*
		 * ApplicationContext和BeanFactory的区别
		 * 		(1) ApplicationContext是BeanFactory的子接口,在BeanFactory基础之上进行了功能扩展
		 * 		(2) BeanFactory: bean的创建时间是懒加载,什么时候用,什么时候创建,
		 * 			ApplicationContext是 new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 * 			new的时候,就会创建出所有非懒加载的单例bean对象
		 * */

		ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
		testBean.print();
		applicationContext.close();
	}


	/**
	 * 循环依赖效果演示
	 * @param args*/
//	public static void main(String[] args) {
//		ClassPathXmlApplicationContext applicationContext =
//				new ClassPathXmlApplicationContext("classpath:applicationContext-cyclic.xml");
////		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		TestService1 testService1 = (TestService1) applicationContext.getBean("testService1");
//		TestService2 testService2 = (TestService2) applicationContext.getBean("testService2");
//		testService1.aTest();
//		testService2.aTest();
//	}

}
