package com.sclbxx;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@RestController
@EnableCircuitBreaker
public class ImHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String home(@RequestParam(value = "name", defaultValue = "im") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

	public String hiError(String name) {
		return "hi,"+name+",sorry,error!";
	}
}
