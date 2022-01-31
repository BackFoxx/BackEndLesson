package servlet;

import dao.TodoDao;
import dto.TodoDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoTypeServlet", value = "/type/*")
public class TodoTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoDao dao = new TodoDao();

        //0. /type/{Id} 형태로 들어온 GET 요청에서 Id만 떼어내어 저장
        Long id = Long.valueOf(request.getPathInfo().split("/")[1]);
        List<TodoDto> todoDtos = dao.getTodo();
        TodoDto dto = null;

        //1. 단건 조회 로직을 만들 수 없으므로 Tododto 리스트에서 id가 같은 dto를 반복문으로 찾아 저장
        for (TodoDto searchDto : todoDtos) {
            if (searchDto.getId() == id) {
                dto = searchDto;
                break;
            }
        }

        //2. dto의 타입을 업데이트
        dao.updateTodo(dto);
    }
}
