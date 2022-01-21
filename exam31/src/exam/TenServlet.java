package exam;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class TenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("test/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<h1>1-10까지 출력!!</h1>");
//        for (int i = 0; i < 10; i++) {
//            out.println(i+"<br>");
//        }
//        out.close();
    }
}
