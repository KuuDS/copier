package me.kuuds.copier.api;

import me.kuuds.copier.domain.User;
import me.kuuds.copier.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * Http Auth Filter
 */
public class GlobalFilter extends HttpFilter {

    private final String[] denyList = new String[]{};
    private final String[] allowList = new String[]{"/user"};

    @Autowired
    private UserRepository userRepository;

    protected void doFilter(HttpServletRequest request, HttpServletResponse response,
                            FilterChain chain) throws IOException, ServletException {
        if (request.getRequestURI().startsWith("/user")) {
            
        }
        String apiKey = request.getHeader("Authorization");
        Optional<User> user = userRepository.findUserByApiKey(apiKey);
        if (user.isPresent()) {
            super.doFilter(request, response, chain);
        } else {
            response.sendError(401);
        }
    }
}
