package controller;

import dao.Order.OrderDAO;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "Servlet2", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;

    public void init() {
        orderDAO = new OrderDAO();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteOrder(request, response);
                    break;
                default:
                    listOrder(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    addOrder(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateOrder(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void listOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> listOrder = orderDAO.findAllOrders();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order existingOrder = orderDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/edit.jsp");
        request.setAttribute("order", existingOrder);
        dispatcher.forward(request, response);

    }
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderDAO.deleteOrder(id);

        List<Order> listOrder = orderDAO.findAllOrders();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/list.jsp");
        dispatcher.forward(request, response);
    }
    private void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        Date date = Date.valueOf(request.getParameter("Date"));
//        Date date1 = (Date) new SimpleDateFormat("MM/dd/yyyy").parse(date);
        int customerId = Integer.parseInt(request.getParameter("CustomerID"));
        int isPay = Integer.parseInt(request.getParameter("Status"));
        Order newOrder = new Order(date, customerId, isPay);
        orderDAO.addOrder(newOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Date date = Date.valueOf(request.getParameter("Date"));
        int customerId = Integer.parseInt(request.getParameter("CustomerID"));
        int isPay = Integer.parseInt(request.getParameter("Status"));

        Order order = new Order(orderId, date, customerId, isPay);
        orderDAO.updateOrder(order);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/edit.jsp");
        dispatcher.forward(request, response);
    }

}
