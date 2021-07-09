package controller;

import dao.Category.CategoryDAO;
import model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }

        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteCategory(request,response);
                break;
            case "back":
                backToList(request,response);
                break;
            default:
                listCategory(request,response);
                break;
        }
    }
    private void backToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createCategory(request, response);
                    break;
                case "edit":
                    editCategory(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void listCategory(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Category/category.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    public void editCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter(" name");
        String description = request.getParameter("description");

        Category category = new Category(id, name, description);
        try {
            categoryDAO.updateCategory(category);
            listCategory(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createCategory(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Category category = new Category(1, name, description);
        try {
            categoryDAO.createCategory(category);
            listCategory(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            categoryDAO.deleteCategory(id);
            listCategory(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Category/create.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    };
    public void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDAO.searchCategory(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Category/edit.jsp");
        request.setAttribute("category", category);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
