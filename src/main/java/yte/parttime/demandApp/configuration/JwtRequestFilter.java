package yte.parttime.demandApp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import yte.parttime.demandApp.login.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Value("${security.jtw.secret-key}")
    private String secretKey;

    private final UserDetailsService userDetailsService;

    public JwtRequestFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")){
            String jwtToken =authorizationHeader.substring(7);
            String userName = JwtUtil.extratUserName(jwtToken,secretKey);

            UserDetails userDetails =userDetailsService.loadUserByUsername(userName);

            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        filterChain.doFilter(request,response);
    }
}
