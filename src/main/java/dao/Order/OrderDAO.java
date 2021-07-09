package dao.Order;

import dao.SQL.SQLConnection;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    SQLConnection sqlConnection = new SQLConnection();
    private static final String ADD_ORDERS_SQL = "INSERT INTO orders" + "  (date, customerID, isPay) VALUES " +
            " (?, ?, ?);";

    private static final String FIND_ORDER_BY_ID = "select OrderId,date,customerID,isPay from orders where OrderId =?";
    private static final String FIND_ALL_ORDERS = "select * from orders";
    private static final String DELETE_ORDERS_SQL = "delete from orders where OrderId = ?;";
    private static final String UPDATE_ORDERS_SQL = "update orders set date = ?,customerID= ?, isPay =? where OrderId = ?;";

    public OrderDAO(){
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        Connection connection =sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDERS_SQL);
        preparedStatement.setDate(1, (Date) order.getDate());
        preparedStatement.setInt(2,order.getCustomerId());
        preparedStatement.setInt(3,order.getIsPay());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();

    }

    @Override
    public Order findById(int orderId) throws SQLException {
        Order order = null;
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ORDER_BY_ID);
        preparedStatement.setInt(1,orderId);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            Date date = rs.getDate("date");
            int customerId = rs.getInt("customerID");
            int isPay = rs.getInt("isPay");
            order = new Order(orderId,date,customerId,isPay);
        }

        return order;
    }

    @Override
    public List<Order> findAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_ORDERS);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            int orderId = rs.getInt("OrderId");
            Date date = rs.getDate("date");
            int customerId = rs.getInt("customerID");
            int isPay = rs.getInt("isPay");
            orders.add(new Order(orderId,date,customerId,isPay));

        }
        return orders;
    }

    @Override
    public boolean deleteOrder(int orderId) throws SQLException {
        boolean rowDeleted;
        Connection connection =sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDERS_SQL);
        preparedStatement.setInt(1,orderId);
        rowDeleted = preparedStatement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        boolean rowUpdated;
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDERS_SQL);
        preparedStatement.setDate(1,order.getDate());
        preparedStatement.setInt(2,order.getCustomerId());
        preparedStatement.setInt(3,order.getIsPay());
        preparedStatement.setInt(4,order.getOrderId());
        rowUpdated = preparedStatement.executeUpdate()>0;
        return rowUpdated;
    }
}