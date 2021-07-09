package dao.Customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomer {
    List<Customer> findAll()throws SQLException ;
    void  add(Customer customer) throws SQLException;
    List<Customer> findByName(String customerName) throws SQLException;
    Customer findByID(int customerID) throws SQLException;
    List<Customer> findByPhone(String customerPhone) throws SQLException;
    boolean checkLogin(String username, String password);

}