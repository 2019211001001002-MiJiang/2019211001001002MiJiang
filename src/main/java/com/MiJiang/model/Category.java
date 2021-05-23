package main.java.com.MiJiang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int CategoryId;
    private String CategoryName;
    private  String Description;
    private boolean Active;
    public  Category(){

    }

    public Category(int categoryId, String categoryName, String description, boolean active) {
        CategoryId = categoryId;
        CategoryName = categoryName;
        Description = description;
        Active = active;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryId=" + CategoryId +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                ", Active=" + Active +
                '}';
    }
    public static List<Category> findAllCategory(Connection con) {
        List<Category> list = new ArrayList<Category>();
        String sql = "select * from Category";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Category c=new Category();
                c.setCategoryId(resultSet.getInt("categoryId"));
                c.setCategoryName(resultSet.getString("categoryName"));
                c.setDescription(resultSet.getString("description"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return list;
    }
    public  static String findByCategoryId(Connection con,int categoryId){
        String categoryName=null;
        String sql="select CategoryName from Category where CategoryId=?";

        try {

            PreparedStatement statement=con.prepareStatement(sql);
            statement.setInt(1,categoryId);
            ResultSet resultSet=statement.executeQuery();
            while ((resultSet.next())){
                categoryName=resultSet.getString("categoryName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryName;
    }

}
