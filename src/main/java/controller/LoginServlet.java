package controller;

import dao.Customer.CustomerDAO;
import dao.Customer.ICustomer;
import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private ICustomer customer = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//        dispatcher.forward(request, response);
//        RequestDispatcher dispatcher;
//
//        String userName = request.getParameter("userName");
//        String passWord = request.getParameter("passWord");
//        if (userName.equals("admin") && passWord.equals("admin1")) {
//            dispatcher = request.getRequestDispatcher("admin/admin.jsp");
//            dispatcher.forward(request, response);
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            default:
                showLogin(request, response);
        }
    }

    public void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/Login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "goto":
                goTo(request, response);
                break;
            case "addCustomer":
                try {
                    signUp(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    public void goTo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
//        requestDispatcher.forward(request, response);
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        boolean check = customer.checkLogin(userName, passWord);
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;


        if (check) {
            session.setAttribute("username", userName);
            response.sendRedirect("/UserProduct");
        } else {
            if (userName.equals("admin") && passWord.equals("admin1")) {
                dispatcher = request.getRequestDispatcher("admin/admin.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("Product/Login.jsp");
                request.setAttribute("msg", "User account or password incorrect! Please re-enter.");
            }
            dispatcher.forward(request, response);
        }


    }

    public void signUp(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        Customer customer1 = new Customer(name, phone, email, userName, password);
        customer.add(customer1);
        try {
            showLogin(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void signOut(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request,response);
    }
}
