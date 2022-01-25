package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/logic")
public class LogicServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        int v1 = (int)(Math.random() * 100) + 1;
        int v2 = (int)(Math.random() * 100) + 1;
        int result = v1 + v2;

        req.setAttribute("v1", v1);
        req.setAttribute("v2", v2);
        req.setAttribute("result", result);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/result.jsp");
        requestDispatcher.forward(req,res);
    }

}
