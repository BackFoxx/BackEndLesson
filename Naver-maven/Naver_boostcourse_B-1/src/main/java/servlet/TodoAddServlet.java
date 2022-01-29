package servlet;

import dao.TodoDao;
import dto.TodoDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoAddServlet", value = "/TodoAddServlet")
public class TodoAddServlet extends HttpServlet {

    TodoDao dao = new TodoDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        TodoDto dto = new TodoDto();
        dto.setTitle(request.getParameter("title"));
        dto.setName(request.getParameter("name"));
        dto.setSequence(Integer.parseInt(request.getParameter("sequence")));

        dao.addTodo(dto);

        response.sendRedirect("/main");
    }
}
