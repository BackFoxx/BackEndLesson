package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/front")
public class FrontServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        int diceValue = (int)(Math.random() * 6) + 1;
        request.setAttribute("dice", diceValue);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next");
        requestDispatcher.forward(request, response);
    }
}
