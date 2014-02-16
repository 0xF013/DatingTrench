package com.datingtrench.mvc.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by elvis on 2/16/14.
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {


    private String authenticatedRoleName;

    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        boolean requestIsPublic = uri.startsWith("/public") || "/".equals(uri);
        try {
            if (request.isUserInRole(authenticatedRoleName)) {
                if (requestIsPublic) {
                    response.sendRedirect("/users");
                }
            } else {
                if (!requestIsPublic) {
                    response.sendRedirect("/");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }

        return true;
    }

    public void setAuthenticatedRoleName(String authenticatedRoleName) {
        this.authenticatedRoleName = authenticatedRoleName;
    }
}
