package servlet;

import dao.TodoDao;
import dto.TodoDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    TodoDao dao = new TodoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TodoDto> todo = dao.getTodo();
        request.setAttribute("todo", todo);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(request, response);
    }
}
