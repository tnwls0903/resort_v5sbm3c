package dev.mvc.mvcjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.mvc"}) // ★★★★★★ 패키지 주의 ★★★★★★ 
public class MvcjsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcjsApplication.class, args);
	}

}
