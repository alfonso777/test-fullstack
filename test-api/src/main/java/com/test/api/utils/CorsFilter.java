package com.test.api.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

//Enable when cross-domain support is needed
//@Component
public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addIntHeader("Access-Control-Max-Age", 10);
		filterChain.doFilter(request, response);
	}
}