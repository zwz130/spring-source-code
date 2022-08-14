package com.itheima.config;

import javafx.scene.layout.Priority;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

public class User  implements Ordered , PriorityOrdered {

	@Override
	public int getOrder() {
		return 0;
	}
}
