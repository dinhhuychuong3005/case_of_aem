package dao.OrderDetail;

import model.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDetail {
    public void createOrderDetail(OrderDetail orderDetail) throws SQLException;

    public List<OrderDetail> searchOrderDetail(int id);

    public List<OrderDetail> getAllOrderDetail();

    public boolean deleteOrderDetail(int id1, int id2) throws SQLException;
}
