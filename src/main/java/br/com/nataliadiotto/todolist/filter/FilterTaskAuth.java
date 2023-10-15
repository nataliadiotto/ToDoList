package br.com.nataliadiotto.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.nataliadiotto.todolist.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component //asking spring to manage this class
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            //restraining to the /tasks/ route
            var servletPath = request.getServletPath();

            if (servletPath.startsWith("/tasks/")) {
                //catch authentication (user and password)
                var authorization = request.getHeader("Authorization");
                var encodedAuth = authorization.substring("Basic".length()).trim();

                byte[] decodedAuth = Base64.getDecoder().decode(encodedAuth); //decode and create a bytes array

                var authString = new String(decodedAuth);

                String[] credentials = authString.split(":");
                String username = credentials[0];
                String password = credentials[1];

                System.out.println("Authorization");
                System.out.println(username);
                System.out.println(password);
                //validate user
                var user = this.userRepository.findByUsername(username);
                if (user == null) {
                    response.sendError(401);
                } else {
                    //validate password
                    //convert to charArray and compare the password stored in the DB to the one received by user
                    var verifyPassword = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                    if (verifyPassword.verified) {
                        request.setAttribute("userId", user.getId());
                        filterChain.doFilter(request, response);
                    } else {
                        response.sendError(401);
                    }
                }
            } else {
                filterChain.doFilter(request, response);
            }
    }

}
