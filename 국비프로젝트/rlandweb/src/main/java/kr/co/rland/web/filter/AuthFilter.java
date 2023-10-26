package kr.co.rland.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("Filter");

//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
//        Object username_ = session.getAttribute("username");
//
//        if(username_ == null)
//            request
//        .getRequestDispatcher("/user/login?returnURL=/menu/list")
//        .forward(request, response);

        filterChain.doFilter(request, response);

    }
}
