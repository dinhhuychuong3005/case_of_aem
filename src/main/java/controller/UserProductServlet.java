package controller;

import dao.Product.IProduct;
import dao.Product.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserProductServlet", value = "/UserProduct")
public class UserProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail":
                showProductDetail(request,response);
                break;
            default:
                showListProduct(request, response);
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.getAllProduct();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/Test2.jsp");
        dispatcher.forward(request, response);
    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productDAO.searchProduct(productId);
        List<Product> list = productDAO.getAllProduct();
        HttpSession session = request.getSession();
        session.setAttribute("productId",productId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/productDetail.jsp");
        request.setAttribute("products",product);
        request.setAttribute("productList",list);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
