package DAO;

import ConnectDB.Connect;
import Model.Personn.Customers;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO implements DAOinterface<Customers> {
    public static CustomerDAO getCusDAO(){
        return new CustomerDAO();
    }

    @Override
    public int insert(Customers customers) {
        try (Connection con = Connect.getConnection()) {
            String sql = "INSERT INTO Customer(CusID, Name, Address, Gender, Phone) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, customers.getCusId());
                pstmt.setString(2, customers.getName());
                pstmt.setString(3, customers.getAddress());
                pstmt.setString(4, customers.getGender());
                pstmt.setString(5, customers.getPhone());

                int ketqua = pstmt.executeUpdate();

                System.out.println("da thuc thi : " + sql);
                System.out.println("Co " + ketqua + " dong bi thay doi");

                return ketqua;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Customers customers) {
        try (Connection con = Connect.getConnection()) {
            String sql = "UPDATE Customer SET Name=?, Address=?, Gender=?, Phone=? WHERE CusID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, customers.getName());
                pstmt.setString(2, customers.getAddress());
                pstmt.setString(3, customers.getGender());
                pstmt.setString(4, customers.getPhone());
                pstmt.setInt(5, customers.getCusId());

                int ketqua = pstmt.executeUpdate();

                System.out.println("da thuc thi : " + sql);
                System.out.println("Co " + ketqua + " dong bi thay doi");

                return ketqua;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int delete(Customers customers) {
        try (Connection con = Connect.getConnection()) {
            String sql = "DELETE FROM Customer WHERE CusID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, customers.getCusId());

                int ketqua = pstmt.executeUpdate();

                System.out.println("da thuc thi : " + sql);
                System.out.println("Co " + ketqua + " dong bi xoa");

                return ketqua;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Customers> selectAll() {
        ArrayList<Customers> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM customer";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int CusID = rs.getInt("CusID");
                    String Name = rs.getString("Name");
                    String Address = rs.getString("Address");
                    String Gender = rs.getNString("Gender");
                    String Phone = rs.getString("Phone");

                    Customers cus = new Customers(CusID, Name, Address, Gender, Phone);
                    ketqua.add(cus);
                }
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }


    @Override
    public Customers selectById(Customers customers) {
        Customers ketqua = null;
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM customer WHERE CusID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1,customers.getCusId());
                ResultSet rs = pstmt.executeQuery();
                    int CusID = rs.getInt("CusID");
                    String Name = rs.getString("Name");
                    String Address = rs.getString("Address");
                    String Gender = rs.getString("Gender");
                    String Phone = rs.getString("Phone");

                    ketqua = new Customers(CusID, Name, Address, Gender, Phone);
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<Customers> selectByCondition(String condition) {
        return null;
    }
}