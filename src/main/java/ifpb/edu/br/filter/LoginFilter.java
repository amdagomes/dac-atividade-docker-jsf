/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cliente
 */
package ifpb.edu.br.filter;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse res = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/faces/index.xhtml";

        boolean loggedIn = session != null && session.getAttribute("usuario") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        if (loggedIn || loginRequest || resourceRequest) {
            chain.doFilter(request, res);
        } else {
            res.sendRedirect(loginURI);
        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
