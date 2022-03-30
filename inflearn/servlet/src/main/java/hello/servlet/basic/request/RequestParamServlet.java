package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println("전체 파라미터 조회---------------Start");

        parameterNames.asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " : " + request.getParameter(paramName)));

        System.out.println("전체 파라미터 조회---------------End");
        System.out.println();

        System.out.println("단일 파라미터 조회---------------Start");

        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("단일 파라미터 조회---------------End");
        System.out.println();

        System.out.println("이름이 같은 복수 파라미터 조회---------------Start");
        String[] usernames = request.getParameterValues("username");
        for (String u : usernames) {
            System.out.println(u);
        }
        System.out.println("이름이 같은 복수 파라미터 조회---------------End");

        response.getWriter().write("ok");
    }
}
