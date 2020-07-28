package com.quickgroceries.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The Class CartMicroserviceApplication.
 */
@SpringBootApplication(scanBasePackages = { "com.quickgroceries.cart" })
@EnableDiscoveryClient
@EnableFeignClients("com.quickgroceries.cart")
public class CartMicroserviceApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CartMicroserviceApplication.class, args);
	}

}
