package com.google.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	private String enc;
	
    public EncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(enc);
//		System.out.println("Encoding Fileter IN");
		
		chain.doFilter(request, response);
		
		response.setCharacterEncoding(enc );
//		System.out.println("Encoding Fileter OUT");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		enc = fConfig.getInitParameter("enc");
	}

}
