package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.TodoDao;
import dto.TodoDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet(name = "TodoAddServlet", value = "/add")
public class TodoAddServlet extends HttpServlet {

    TodoDao dao = new TodoDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String json = null;
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                json = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        JsonElement element = JsonParser.parseString(json);
        JsonObject object = element.getAsJsonObject();
        String title = object.get("title").getAsString();
        String name = object.get("name").getAsString();
        int sequence = object.get("sequence").getAsInt();

        TodoDto dto = new TodoDto();
        dto.setTitle(title);
        dto.setName(name);
        dto.setSequence(sequence);

        dao.addTodo(dto);
    }
}
