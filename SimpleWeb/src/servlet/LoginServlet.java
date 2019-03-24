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
 
import workers.*;
import model.*;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    // �������� �������� Login.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Forward (�������������) � �������� /WEB-INF/views/loginView.jsp
        // (������������ �� ����� ����� �������� ������
        // � ��������� JSP ������������� � ����� WEB-INF).
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    // ����� ������������ ������ userName & password, � �������� Submit.
    // ���� ����� ����� ��������.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
 
        Admins admin = null;
        boolean hasError = false;
        String errorString = null;
 
        if (login == null || password == null || login.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                // ����� user � DB.
                admin = AdminWorker.findAdmin(conn, login, password);
 
                if (admin == null) {
                    hasError = true;
                    errorString = "Name or password invalid";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        // � ������, ���� ���� ������,
        // forward (�������������) � /WEB-INF/views/login.jsp
        if (hasError) {
            admin = new Admins();
            admin.setLogin(login);
            admin.setPassword(password);
 
            // ��������� ���������� � request attribute ����� forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("admin", admin);
 
            // Forward (�������������) � �������� /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
            dispatcher.forward(request, response);
        }
        // � ������, ���� ��� ������.
        // ��������� ���������� ������������ � Session.
        // � ������������� � �������� userInfo.
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, admin);
 
            // ���� ������������ �������� ������� "Remember me".
            if (remember) {
                MyUtils.storeUserCookie(response, admin);
            }
            // ��������, ������� Cookie
            else {
                MyUtils.deleteUserCookie(response);
            }
 
            // Redirect (�������������) �� �������� /userInfo.
            response.sendRedirect(request.getContextPath() + "/sandwichesList");
        }
    }
 
}