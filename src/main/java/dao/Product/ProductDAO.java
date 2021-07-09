package dao.Product;

import dao.SQL.SQLConnection;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProduct {

    SQLConnection sqlConnection = new SQLConnection();

    @Override
    public void createProduct(Product product) throws SQLException {

        String query = "insert into product values(?,?,?,?,?,?,?,?) ";
        try {
            Connection connection = sqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getProductPrice());
            preparedStatement.setString(4, product.getProductColor());
            preparedStatement.setInt(5, product.getProductQuantity());
            preparedStatement.setString(6, product.getProductDescription());
            preparedStatement.setString(7, product.getProductImage());
            preparedStatement.setInt(8, product.getCategoryID());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product searchProduct(int id) {
        Product product = null;
        String query = "{Call get_product_by_id(?)}";
        try {
            Connection connection = sqlConnection.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                int price = rs.getInt(3);
                String color = rs.getString(4);
                int quantity = rs.getInt(5);
                String description = rs.getString(6);
                String image = rs.getString(7);
                int categoryId = rs.getInt(8);
                product = new Product(id, name, price, color, quantity, description, image, categoryId);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        String query = "{Call_get_all_product()}";
        try {
            Connection connection = sqlConnection.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                String color = rs.getString(4);
                int quantity = rs.getInt(5);
                String descsciption = rs.getString(6);
                String image = rs.getString(7);
                int categoryId = rs.getInt(8);
                Product product = new Product(id, name, price, color, quantity, descsciption, image, categoryId);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean isdelete = false;
        String query = "{CALL delete_product(?)}";
        try {
            Connection connection = sqlConnection.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            isdelete = callableStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isdelete;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean isUpdate = false;
        String query = "{CALL update_product(?,?,?,?,?,?,?,?)}";
        try {
            Connection connection = sqlConnection.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, product.getProductId());
            callableStatement.setString(2, product.getProductName());
            callableStatement.setInt(3, product.getProductPrice());
            callableStatement.setString(4, product.getProductColor());
            callableStatement.setInt(5, product.getProductQuantity());
            callableStatement.setString(6, product.getProductDescription());
            callableStatement.setString(7, product.getProductImage());
            callableStatement.setInt(8, product.getCategoryID());
            isUpdate = callableStatement.execute();
            System.out.println(query);
            System.out.println(callableStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdate;
    }
}
