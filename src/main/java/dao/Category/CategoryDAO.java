package dao.Category;

import dao.SQL.SQLConnection;
import model.Category;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    SQLConnection sqlConnection = new SQLConnection();
    @Override
    public boolean createCategory(Category category) throws SQLException {
        boolean isCreated = false;
        String query= "{CALL create_category(?,?)}";
        try {
            Connection connection = sqlConnection.getConnection();
            if(connection!=null){
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setString(1,category.getCategoryName());
                callableStatement.setString(2,category.getCategoryDescription());
                isCreated = callableStatement.executeUpdate() >0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public Category searchCategory(int id) {
        Category category = null;
        String query = "{CALL get_category_by_id(?)}";
        try {
            Connection connection = sqlConnection.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String  name = rs.getString("categoryName");
                String desciption = rs.getString("categoryDescription");
                category = new Category(id,name,desciption);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        String query = "{CALL get_all_category()}";
        try {
            Connection connection = sqlConnection.getConnection();
            CallableStatement callableStatement =connection.prepareCall(query);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description= rs.getString(3);

                categories.add(new Category(id,name,description));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public boolean deleteCategory(int id) throws SQLException {
        boolean isDelete = false;
        String query = "{CALL delete_category(?)}";
        try {
            Connection connection = sqlConnection.getConnection();
            CallableStatement callableStatement= connection.prepareCall(query);
            callableStatement.setInt(1,id);
            callableStatement.execute();
            isDelete = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isDelete;
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
        boolean isUpdate = false;
        String query = "{CALL update_category(?,?,?)}";
        try {
            Connection connection = sqlConnection.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,category.getCategoryId());
            callableStatement.setString(2,category.getCategoryName());
            callableStatement.setString(3,category.getCategoryDescription());

            isUpdate = callableStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isUpdate;
    }
}
