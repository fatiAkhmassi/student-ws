package dev.fatima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
@EnableEurekaClient
@SpringBootApplication
public class GatewayServiceApplication {

	@Autowired
	private JwtAuthorizationFilter filter;
	private JwtAuthorizationAdminRoleFilter roleFilter;
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
		
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
	return builder.routes()
	.route(r->r.path("/etudiants/**").filters(f->f.filter(filter)).uri("lb://ETUDIANT-SERVICE"))
	.route(r->r.path("/rooms/**").filters(f->f.filter(filter)).uri("lb://ROOM-SERVICE"))
	.route(r->r.path("/examains/**").filters(f->f.filter(filter).filter(roleFilter)).uri("lb://EXAMAIN-SERVICE"))
	.route(r->r.path("/auth/**").uri("lb://authentication-service"))
	.build();
	}

}
