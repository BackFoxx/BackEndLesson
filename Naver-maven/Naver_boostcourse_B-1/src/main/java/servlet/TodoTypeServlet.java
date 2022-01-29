package servlet;

import com.mysql.cj.xdevapi.JsonParser;
import dao.TodoDao;
import dto.TodoDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoTypeServlet", value = "/type/*")
public class TodoTypeServlet extends HttpServlet {
    TodoDao dao = new TodoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getPathInfo().split("/")[1]);
        List<TodoDto> todoDtos = dao.getTodo();
        TodoDto dto = null;

        for (TodoDto searchDto :
                todoDtos) {
            if (searchDto.getId() == id) {
                dto = searchDto;
                break;
            }
        }

        System.out.println("id = " + id);
        System.out.println("dto = " + dto);

        dao.updateTodo(dto);

        TodoDto one = dao.findOne(id);
        System.out.println("one = " + one);
    }
}
