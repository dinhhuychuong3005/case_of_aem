package controller;

import dao.Product.ProductDAO;
import model.OrderDetail;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/carts")
public class CartServlet extends HttpServlet {
    List<Product> cart = new ArrayList<>();
    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addToCart(request,response);
                break;
            case "show":
                showCart(request,response);
                break;
            default:
                showListProduct(request,response);
        }
    }
    private void showCart(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = cart;
        double total = 0;
        double sum = 0;
        for (Product p:cart) {
            double price = p.getProductPrice();
            int quantity = p.getProductQuantity();
            sum += price*quantity;
        }
        request.setAttribute("list", list);
        request.setAttribute("sum", sum);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/Cart.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.getAllProduct();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/Test2.jsp");
        dispatcher.forward(request, response);
    }
    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int id = (int) session.getAttribute("productId");
        Product product = productDAO.searchProduct(id);
        if(isOnCart(id)){
            Product p1 = getProductFromCart(id);
            int a = p1.getProductQuantity()+1;
            p1.setProductQuantity(a);
        }else{
            product.setProductQuantity(1);
            cart.add(product);
        }

        showListProduct(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private boolean isOnCart(int id){
        for (Product p: cart
        ) {
            if(p.getProductId()==id){
                return true;
            }
        }
        return false;
    }
    private Product getProductFromCart(int id){
        for (Product p: cart
        ) {
            if(p.getProductId()==id){
                return p;
            }
        }
        return null;
    }
}
