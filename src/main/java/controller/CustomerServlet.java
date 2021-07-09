package controller;

import dao.Customer.CustomerDAO;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerDAO customerDAO=new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatePage(request, response);
                break;
            case "search": ;
                String type = request.getParameter("type");
                if (type.equals("name")){
                    showSearchName(request, response);
                }else if (type.equals("phone")){
                    showSearchPhone(request,response);
                }
                break;
            case "Back":
                backToList(request,response);
                break;
            default:
                showListPage(request, response);
        }
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        requestDispatcher.forward(request, response);
    }
    private void backToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showViewPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/view.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Customer customer = customerDAO.findByID(id);
            request.setAttribute("customer", customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        requestDispatcher.forward(request, response);
    }

    private void showSearchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        String key = request.getParameter("key");
        try {
            List<Customer> customers = customerDAO.findByName(key);
            request.setAttribute("customers", customers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        requestDispatcher.forward(request, response);

    }
    private void showSearchPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        String key = request.getParameter("key");
        try {
            List<Customer> customers = customerDAO.findByPhone(key);
            request.setAttribute("customers", customers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        requestDispatcher.forward(request, response);

    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            List<Customer> customers = customerDAO.findAll();
            request.setAttribute("customers", customers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



}