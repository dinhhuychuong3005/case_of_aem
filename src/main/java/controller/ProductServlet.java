package controller;

import dao.Category.CategoryDAO;
import dao.Product.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    deleteProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } else {
            try {
                switch (action) {
                    case "create":
                        createProduct(request, response);
                        listProduct(request,response);
                        break;
                    case "edit":
                       updateProduct(request,response);
                       listProduct(request,response);
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("productPrice"));
        String color = request.getParameter("productColor");
        int quantity = Integer.parseInt(request.getParameter("productQuantity"));
        String description = request.getParameter("productDescription");
        String image = request.getParameter("productImage");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product updateProduct = new Product(id, name, price, color, quantity, description, image, categoryId);
        productDAO.updateProduct(updateProduct);

    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Product> list = productDAO.getAllProduct();
        request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Product/product.jsp");
        dispatcher.forward(request, response);
    };
    public void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("productPrice"));
        String color = request.getParameter("productColor");
        int quantity = Integer.parseInt(request.getParameter("productQuantity"));
        String description = request.getParameter("productDescription");
        String image = request.getParameter("productImage");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product newProduct = new Product(id, name, price, color, quantity, description, image, categoryId);
        productDAO.createProduct(newProduct);
        listProduct(request, response);
    };
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(productId);
        try {
            listProduct(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    };
    public void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Product exisProduct = productDAO.searchProduct(id);
        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("productlist",exisProduct);
        request.setAttribute("categorylist",categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/edit.jsp");
        dispatcher.forward(request,response);
    };
    public void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("categorylist" , categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/create.jsp");
        dispatcher.forward(request,response);
    }

}
