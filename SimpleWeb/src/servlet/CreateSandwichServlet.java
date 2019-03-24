package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import model.*;
import utils.MyUtils;
import workers.*;
 
@WebServlet(urlPatterns = { "/createSandwich" })
public class CreateSandwichServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateSandwichServlet() {
        super();
    }
 
    // Отобразить страницу создания продукта.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createSandwichView.jsp");
        dispatcher.forward(request, response);
    }
 
    // Когда пользователь вводит информацию продукта, и нажимает Submit.
    // Этот метод будет вызван.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int id = Integer.parseInt((String) request.getParameter("id"));
        String name = (String) request.getParameter("name");
        String type = (String) request.getParameter("type");
        int minutes = Integer.parseInt((String) request.getParameter("minutes"));
        String bread = (String) request.getParameter("bread");
        String comment = (String) request.getParameter("comment");
        
        Sandwiches sandwich = new Sandwiches(id, name, type, minutes, bread, comment);
 
        String errorString = null;

        if (errorString == null) {
            try {
                SandwichWorker.createSandwich(conn, id, name, type, minutes, bread, comment);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("sandwich", sandwich);
 
        // Если имеется ошибка forward (перенаправления) к странице 'edit'.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createSandwichView.jsp");
            dispatcher.forward(request, response);
        }
        // Если все хорошо.
        // Redirect (перенаправить) к странице со списком продуктов.
        else {
            response.sendRedirect(request.getContextPath() + "/sandwichesList");
        }
    }
 
}