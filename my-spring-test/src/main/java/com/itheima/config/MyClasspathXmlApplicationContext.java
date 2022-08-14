package com.itheima.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClasspathXmlApplicationContext extends ClassPathXmlApplicationContext {

	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		super.setAllowBeanDefinitionOverriding(false);
		super.setAllowCircularReferences(false);
		super.customizeBeanFactory(beanFactory);
	}

	@Override
	protected void initPropertySources() {
		//这个类对ClassPathXmlApplicationContext进行增强
		//环境变量中,添加一个属性name
		getEnvironment().setRequiredProperties("name");
		//校验这个属性,
		getEnvironment().validateRequiredProperties();
		super.initPropertySources();
	}

	@Override
	protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		super.postProcessBeanFactory(beanFactory);
	}
}
