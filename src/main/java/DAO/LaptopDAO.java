package DAO;

import ConnectDB.Connect;
import Model.Laptop.Laptop;

import java.sql.*;
import java.util.ArrayList;

public class LaptopDAO implements DAOinterface<Laptop> {
    public static LaptopDAO getLaptopDAO() {
        return new LaptopDAO();
    }

    @Override
    public int insert(Laptop laptop) {
        try (Connection con = Connect.getConnection()){
            String sql ="INSERT INTO Laptop(LapID, Name, Price, Type, About) VALUE(?,?,?,?,?)";
            try(PreparedStatement pstmt = con.prepareStatement(sql)){
                pstmt.setInt(1,laptop.getID());
                pstmt.setString(2,laptop.getName());
                pstmt.setDouble(3,laptop.getPrice());
                pstmt.setString(4,laptop.getType());
                pstmt.setString(5,laptop.getAbout());

                int ketqua = pstmt.executeUpdate();
                return ketqua;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Laptop laptop) {
        try (Connection con = Connect.getConnection()){
            String sql = "UPDATE laptop SET Name=?,Price=?,Type=?,About=? WHER LapID=? ";
            try (PreparedStatement pstmt = con.prepareStatement(sql)){
                pstmt.setString(1, laptop.getName());
                pstmt.setDouble(2, laptop.getPrice());
                pstmt.setString(3, laptop.getType());
                pstmt.setString(4, laptop.getAbout());
                pstmt.setInt(5, laptop.getID());
                pstmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Laptop laptop) {
        try (Connection con = Connect.getConnection()){
            String sql = "DELETE FROM laptop WHERE lapID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)){
                pstmt.setInt(1, laptop.getID());
                pstmt.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Laptop> selectAll() {
        ArrayList<Laptop> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM laptop";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int LapID = rs.getInt("LapID");
                    String Name = rs.getString("Name");
                    Double Price = rs.getDouble("Price");
                    String Type = rs.getNString("Type");
                    String About = rs.getString("About");

                    Laptop lap = new Laptop(LapID, Name, Price, Type, About);
                    ketqua.add(lap);
                }
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Laptop selectById(Laptop laptop) {
        return null;
    }

    @Override
    public ArrayList<Laptop> selectByCondition(String condition) {
        return null;
    }
}