package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoFormServlet", value = "/todo")
public class TodoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0. /todoform.jsp로 포워딩
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/todoForm.jsp");
        requestDispatcher.forward(request, response);

    }
}
