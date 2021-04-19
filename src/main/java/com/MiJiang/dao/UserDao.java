package main.java.com.MiJiang.dao;

import main.java.com.MiJiang.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {

    QueryRunner qr = new QueryRunner();

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into utable(username,password,email,gender,birth) values(?,?,?,?,?)";
        int i = qr.update(con,sql,new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getBirthdate()});
        if (i != 0) {
            return true;
        }else return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from utable where id = ?";
        return  qr.update(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update usertable set name = ?,password = ?, email = ?, gender = ?, birth = ? where id = ?";
        return qr.update(con,sql,new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getBirthdate(),user.getId()});
    }

    @Override
    public User findById(Connection con, String id) throws SQLException {
        String sql = "select * from utable where id =?";
        return  qr.query(con,sql,new BeanHandler<>(User.class));
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from utable WHERE username=? AND password=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        con.close();
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from utable where name = ?";
        return  qr.query(sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from usertable where password = " + password;
        return  qr.query(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from utable where email = ?";
        return  qr.query(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from utable where gender = ?";
        return  qr.query(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select * from utable where birthdate =? ";
        return  qr.query(con,sql,new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "SELECT * FROM utable";
        return qr.query(con,sql,new BeanListHandler<>(User.class));
    }
}
