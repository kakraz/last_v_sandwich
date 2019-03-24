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
import javax.servlet.http.HttpSession;

import java.util.List;
 
import model.*;
import utils.MyUtils;
import workers.*;
 
@WebServlet(urlPatterns = { "/editSandwich" })
public class EditSandwichServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditSandwichServlet() {
        super();
    }
 
    // Отобразить страницу редактирования продукта.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	Admins loginedUser = MyUtils.getLoginedUser(session);
    	
    	 if (loginedUser == null) {
             // Redirect (Перенаправить) к странице login.
             response.sendRedirect(request.getContextPath() + "/login");
             return;
         }
    	 
        Connection conn = MyUtils.getStoredConnection(request);
  
        int id = Integer.parseInt((String)request.getParameter("id"));
 
        Sandwiches sandwich = null;
        List<Ingredients> ingredients = null;
        List<Ingredients> all_ingredients = null;
        List<Addition> additions = null;
        List<Addition> all_additions = null;

  
        String errorString = null;
 
        try {
            sandwich = SandwichWorker.getSandwichById(conn, id);
            ingredients = IngredientsWorker.getIngredientsForSandwich(conn, id);
            all_ingredients = IngredientsWorker.getAllIngredientss(conn);      
            additions = AdditionWorker.getAdditionForSandwich(conn, id);
            all_additions = AdditionWorker.getAllAdditions(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // Ошибки не имеются.
        // Продукт не существует для редактирования (edit).
        if (errorString != null && sandwich == null) {
            response.sendRedirect(request.getServletPath() + "/sandwichesList");
            return;
        }
 
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("sandwich", sandwich);
        request.setAttribute("ingredients", ingredients);
        request.setAttribute("all_ingredients", all_ingredients);
        request.setAttribute("additions", additions);
        request.setAttribute("all_additions", all_additions);
        //request.setAttribute("ing_numbs", ing_numbs);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editSandwichView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // После того, как пользователь отредактировал информацию продукта и нажал на Submit.
    // Данный метод будет выполнен.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        int id = Integer.parseInt((String) request.getParameter("id"));
        String name = (String) request.getParameter("name");
        String type = (String) request.getParameter("type");
        String bread = (String) request.getParameter("bread");
        int minutes = Integer.parseInt((String) request.getParameter("minutes"));
        String comment = (String) request.getParameter("comment");
        Sandwiches sandwich = new Sandwiches(id, name, type, minutes, bread, comment);
 
        String errorString = null;
 
        try {
            SandwichWorker.updateSandwich(conn, id, name, type, minutes, bread, comment);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", sandwich);
 
        // Если имеется ошибка, forward к странице edit.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
            dispatcher.forward(request, response);
        }
        // Если все хорошо.
        // Redirect к странице со списком продуктов.
        else {
            response.sendRedirect(request.getContextPath() + "/sandwichesList");
        }
    }
 
}