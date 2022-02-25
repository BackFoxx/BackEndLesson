package examples;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AppScope02")
public class ApplicationServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();


        try {
            ServletContext application = getServletContext();
            int value = (int) application.getAttribute("value");
            ++value;
            application.setAttribute("value", value);
            out.println("<h1>value : " + value + "</h1>");
        } catch (NullPointerException e) {
            out.print("value의 값이 설정되지 않았습니다.");
        }
    }
}
