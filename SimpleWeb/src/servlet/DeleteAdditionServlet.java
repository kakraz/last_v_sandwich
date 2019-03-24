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
 

import utils.MyUtils;
import workers.*;
 
@WebServlet(urlPatterns = { "/deleteAddition" })
public class DeleteAdditionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteAdditionServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        int id = Integer.parseInt((String)request.getParameter("id"));
        int add_id = Integer.parseInt((String)request.getParameter("add_id"));
 
        String errorString = null;
 
        try {
            CompabilityWorker.deleteCompability(conn, id, add_id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        // ���� ���������� ������, forward (�������������) � �������� ����������� ������.
        if (errorString != null) {
            // ��������� ���������� � request attribute ����� ��� ��� forward � views.
            request.setAttribute("errorString", errorString);
            // 
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
            dispatcher.forward(request, response);
        }
        // ���� ��� ������.
        // Redirect (�������������) � �������� �� ������� ���������.
        else {
            response.sendRedirect(request.getContextPath()+ "/editSandwich?id="+ request.getParameter("id"));
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
