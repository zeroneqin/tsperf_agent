package com.qinjun.autotest.tsperfagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TSPerfAgentApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TSPerfAgentApplication.class);
		springApplication.addListeners(new TSPerfAgentListener());
		springApplication.run(args);
	}
}
