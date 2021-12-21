package dev.fatima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthorizationAdminRoleFilter implements GatewayFilter {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
		final String token = request.getHeaders().getOrEmpty("Authorization").get(0);
		Claims claims = jwtUtil.getClaims(token);
		if(true) {
			ServerHttpResponse response = exchange.getResponse();
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
			return response.setComplete();
		}
		exchange.getRequest().mutate().header("role", String.valueOf(claims.get("role"))).build();
		return chain.filter(exchange);
	}

	
	
}
