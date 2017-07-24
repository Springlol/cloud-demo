package springcloud;

import feign.Feign;
import feign.Logger;
import feign.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//开启断路器
@EnableCircuitBreaker
//开启Feign功能
@EnableFeignClients
public class CloudDemoWebApplication {
	private static final int FIVE_SECONDS = 5000;

	@LoadBalanced //开启软负载均衡
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}

	@Bean
	public Logger.Level feignLogger(){
		return Logger.Level.FULL;
	}

	@Bean
	public Request.Options options(){
		return new Request.Options(FIVE_SECONDS, FIVE_SECONDS);
	}


	public static void main(String[] args) {
		SpringApplication.run(CloudDemoWebApplication.class, args);
	}
}
