package dao.Customer;

import dao.SQL.SQLConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomer {
    SQLConnection sqlConnection = new SQLConnection();
    private String FIND_ALL = "SELECT * FROM customer";
    private String ADD = "INSERT INTO customer (customerName,customerPhone,customerEmail,userName,password) VALUES ( ?,? ,? ,? ,?);";
    private String FIND_BY_NAME = "SELECT * FROM customer WHERE customerName LIKE ?";
    String FIND_BY_ID = "SELECT * FROM customer WHERE customerID = ?";
    String FIND_BY_PHONE = "SELECT * FROM customer WHERE customerPhone LIKE ?";

    @Override
    public List<Customer> findAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int customerID = resultSet.getInt("customerID");
            String customerName = resultSet.getString("customerName");
            String customerPhone = resultSet.getString("customerPhone");
            String customerEmail = resultSet.getString("customerEmail");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            customers.add(new Customer(customerID, customerName, customerPhone, customerEmail, userName, password));
        }
        return customers;
    }

    @Override
    public void add(Customer customer) throws SQLException {
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD);
        preparedStatement.setString(1, customer.getCustomerName());
        preparedStatement.setString(2, customer.getCustomerPhone());
        preparedStatement.setString(3, customer.getCustomerEmail());
        preparedStatement.setString(4, customer.getUserName());
        preparedStatement.setString(5, customer.getPassword());
        preparedStatement.executeUpdate();
    }


    @Override
    public Customer findByID(int customerId) throws SQLException {
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
        preparedStatement.setInt(1, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String customerName = resultSet.getString("customerName");
            String customerPhone = resultSet.getString("customerPhone");
            String customerEmail = resultSet.getString("customerEmail");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            return new Customer(customerId, customerName, customerPhone, customerEmail, userName, password);
        }
        return null;
    }

    @Override
    public List<Customer> findByName(String customerName) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
        preparedStatement.setString(1, "%" + customerName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int customerID = resultSet.getInt("customerID");
            customerName = resultSet.getString("customerName");
            String customerPhone = resultSet.getString("customerPhone");
            String customerEmail = resultSet.getString("customerEmail");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            customers.add(new Customer(customerID, customerName, customerPhone, customerEmail, userName, password));
        }
        return customers;
    }

    @Override
    public List<Customer> findByPhone(String customerPhone) throws SQLException {

        List<Customer> customers = new ArrayList<>();
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PHONE);
        preparedStatement.setString(1, "%" + customerPhone + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int customerID = resultSet.getInt("customerID");
            String customerName = resultSet.getString("customerName");
            customerPhone = resultSet.getString("customerPhone");
            String customerEmail = resultSet.getString("customerEmail");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            customers.add(new Customer(customerID, customerName, customerPhone, customerEmail, userName, password));
        }
        return customers;
    }


    @Override
    public boolean checkLogin(String username, String password) {
        boolean isValid = false;
        try {
            Connection connection = sqlConnection.getConnection();
            String sql = "select * from customer where userName = ? and password = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            } else {
                isValid = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}