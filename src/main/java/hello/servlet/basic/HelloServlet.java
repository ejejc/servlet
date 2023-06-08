package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 서블릿 어노테이션 name = 서블릿 이름 / urlpatterns = url 매핑
@WebServlet(name = "helloServlet", urlPatterns ="/hello")
public class HelloServlet extends HttpServlet {

    /**
     * http 요청이 오면 서블릿 컨테이너(=was)가 request, response 객체를 만들어서 서블릿에 던지는 코드
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // body에 넣어줄 수 있다.
        response.getWriter().write("hello " + username);
    }
}
