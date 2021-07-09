package dao.OrderDetail;

import dao.SQL.SQLConnection;
import model.OrderDetail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO implements IOrderDetail {
        SQLConnection sqlConnection = new SQLConnection();



    @Override
    public void createOrderDetail(OrderDetail orderDetail) throws SQLException {
        Connection connection =sqlConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into orderdetail values(?,?,?,?)");
        preparedStatement.setInt(1,orderDetail.getOrderId());
        preparedStatement.setInt(2,orderDetail.getProductId());
        preparedStatement.setInt(3,orderDetail.getQuantityOd());
        preparedStatement.setDouble(4,orderDetail.getTotal());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<OrderDetail> searchOrderDetail(int id) {
        Connection connection = sqlConnection.getConnection();
        List<OrderDetail> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from orderdetail where orderId = ?");

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt(2);
                int quantity = rs.getInt(3);
                int total = rs.getInt(4);

                OrderDetail orderDetail = new OrderDetail(id, productId, quantity, total);
                list.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<OrderDetail> getAllOrderDetail() {
        Connection connection = sqlConnection.getConnection();
        List<OrderDetail> list = new ArrayList<>();
        try {


            PreparedStatement preparedStatement = connection.prepareStatement("select* from orderdetail ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                int productId = rs.getInt("productId");
                int quantity = rs.getInt("quantityOrder");
                double total = rs.getDouble("payAmount");
                list.add(new OrderDetail(orderId, productId, quantity, total));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteOrderDetail(int id,int id2) throws SQLException {
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("delete from Orderdetail where OrderId=? and ProductId = ?");
        boolean isDelete = false;
        try {
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,id2);
            isDelete = preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isDelete;
    }
}
