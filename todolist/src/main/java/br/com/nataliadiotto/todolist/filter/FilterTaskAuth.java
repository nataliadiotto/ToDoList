package br.com.nataliadiotto.todolist.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component //asking spring to manage this class
public class FilterTaskAuth extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //catch authentication (user and password)
        var authorization = request.getHeader("Authorization");
        var encodedAuth = authorization.substring("Basic".length()).trim();

        byte[] decodedAuth = Base64.getDecoder().decode(encodedAuth); //create a bytes array

        var authString = new String(decodedAuth);

        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        System.out.println("Authorization");
        System.out.println(username);
        System.out.println(password);
        //validate user
        
        //validate password
        
        

        filterChain.doFilter(request, response);
    }
}
