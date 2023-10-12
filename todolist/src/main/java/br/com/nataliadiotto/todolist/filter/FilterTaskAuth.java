package br.com.nataliadiotto.todolist.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component //asking spring to manage this class
public class FilterTaskAuth extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //catch authentication (user and password)
        var authorization = request.getHeader("Authorization");
        var user_password = authorization.substring("Basic".length()).trim();

        System.out.println("Authorization");
        System.out.println(user_password);
        
        //validate user
        
        //validate password
        
        

        filterChain.doFilter(request, response);
    }
}
