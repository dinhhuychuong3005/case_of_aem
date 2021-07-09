package dao.Order;

import model.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDAO {
    public void addOrder(Order order) throws SQLException;
    public Order findById(int orderId) throws SQLException;
    public List<Order> findAllOrders() throws SQLException;
    public boolean deleteOrder(int orderId) throws SQLException;
    public boolean updateOrder(Order order) throws SQLException;

}
