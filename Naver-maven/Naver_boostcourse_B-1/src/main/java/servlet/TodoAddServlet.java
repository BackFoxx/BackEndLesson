package servlet;

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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        //0. application/json으로 들어온 데이터를 BufferedReader를 이용해 저장
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

        //1. gson 라이브러리를 이용해 json 데이터를 dto로 저장
        JsonElement element = JsonParser.parseString(json);
        JsonObject object = element.getAsJsonObject();
        String title = object.get("title").getAsString();
        String name = object.get("name").getAsString();
        int sequence = object.get("sequence").getAsInt();

        TodoDto dto = new TodoDto();
        dto.setTitle(title);
        dto.setName(name);
        dto.setSequence(sequence);

        //2. 저장된 dto 객체를 DB에 저장
        TodoDao dao = new TodoDao();
        dao.addTodo(dto);
    }
}
