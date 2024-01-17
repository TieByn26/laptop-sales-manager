package DAO;

import ConnectDB.Connect;
import Model.Laptop.Laptop;
import Model.Login.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAO implements DAOinterface<Login>{
    public static LoginDAO getLogin(){
        return new LoginDAO();
    }
    @Override
    public int insert(Login login) {
        return 0;
    }

    @Override
    public int update(Login login) {
        try (Connection con = Connect.getConnection()){
            String sql = "UPDATE Admin SET Pass=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)){
                pstmt.setString(1, login.getPassword());
                pstmt.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Login login) {
        return 0;
    }

    @Override
    public ArrayList<Login> selectAll() {
        ArrayList<Login> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM Admin";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String user = rs.getString("Userr");
                    String password = rs.getString("Pass");
                    Login log = new Login(user,password) ;
                    ketqua.add(log);
                }
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Login selectById(Login login) {
        return null;
    }

    @Override
    public ArrayList<Login> selectByCondition(String condition) {
        return null;
    }
}
