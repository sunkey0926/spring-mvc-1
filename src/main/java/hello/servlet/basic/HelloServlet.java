package hello.servlet.basic;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
@Slf4j
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("HelloServlet.service");
        log.info("[request : {}]", request);
        log.info("[response :{}]", response);

        log.info("[request.getRequestURI : {}]", request.getRequestURI());
        log.info("[request.getRequestURL : {}]", request.getRequestURL());
        log.info("[request.getParameter: {}]", request.getParameter("username"));
        String username = request.getParameter("username");

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);

        String uuid = UUID.randomUUID().toString();

        request.setAttribute("key", uuid);



    }
}
