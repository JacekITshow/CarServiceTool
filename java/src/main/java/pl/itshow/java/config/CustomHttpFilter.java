package pl.itshow.java.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class CustomHttpFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String path = request.getRequestURI();

        if (!path.startsWith("/api") &&
                !path.endsWith(".html") &&
                !path.endsWith(".css") &&
                !path.endsWith(".js") &&
                !path.endsWith(".ico") &&
                !path.endsWith(".png") &&
                !path.endsWith(".svg") &&
                !path.endsWith(".jpg") &&
                !path.endsWith(".ttf") &&
                !path.endsWith(".woff") &&
                !path.endsWith(".woff2") &&
                !path.endsWith(".jpeg")) {
            request.getRequestDispatcher("index.html").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
