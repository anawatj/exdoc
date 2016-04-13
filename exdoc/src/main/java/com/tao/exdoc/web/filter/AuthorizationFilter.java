package com.tao.exdoc.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
@Component
public class AuthorizationFilter extends GenericFilterBean {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
	    HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String inputPath = request.getRequestURI().replaceFirst("^/[^\\/]+/", "/");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setHeader("Access-Control-Max-Age", "360");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        // if not a page request, skip filter
     if (inputPath.matches("^/resources/.+") || !inputPath.matches("^/*.+\\.html(\\?.*)?")
                || inputPath.matches("^/(index|error|unauthorized|login)\\.html(\\?.*)?")) {
            chain.doFilter(request, response);
            return;
        }
        //System.out.println("page request: " + inputPath);

        // if not a authenticated request, return unauthorized error.
       if (SecurityContextHolder.getContext().getAuthentication() == null
                || !SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            //System.out.println("not a authenticated request, return unauthorized error.");
            //response.setStatus(403);
            //response.sendRedirect(request.getContextPath() + "/unauthorized.html");
            //return;
        } else {
            Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            // if userDetails can't be read, return unauthorized error.
            if (userDetails == null || !(userDetails instanceof UserDetails)) {
                System.out.println("userDetails can't be read, return unauthorized error.");
                response.setStatus(403);
               // response.sendRedirect(request.getContextPath() + "/unauthorized.html");
                return;
            } else {
                UserDetails user = (UserDetails) userDetails;
               /*  boolean result = authorizationService.isAuthorizedByUser("ZO002", user.getUsername(), inputPath, null,
                 null, null, null);*/
               //  System.out.println("is user " + user.getUsername() + " Authorized?: " + result);

                 // if user is not authorized, return unauthorized error.
               /*  if (!result && !user.getUsername().equals("ANANC")) {
                 System.out.println("user is not authorized, return unauthorized error.");
                 response.setStatus(403);
                 response.sendRedirect(request.getContextPath() + "/unauthorized.html");
                 return;*/
            }
        }
        chain.doFilter(req, res);
	}

}
