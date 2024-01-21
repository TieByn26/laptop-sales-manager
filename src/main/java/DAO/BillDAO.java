package DAO;

import ConnectDB.Connect;
import Model.Laptop.Bill;
import Model.Laptop.Laptop;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillDAO implements DAOinterface<Bill>{
    public static BillDAO getBillDAO(){
        return new BillDAO();
    }

    @Override
    public int insert(Bill bill) {
        try (Connection con = Connect.getConnection()) {
            String sql = "INSERT INTO bill(CusID,LapID,Status) VALUES ( ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, bill.getCusID());
                pstmt.setInt(2, bill.getLapID());
                pstmt.setString(3,bill.getStatus());

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
    public int update(Bill bill) {
        try (Connection con = Connect.getConnection()) {
            String sql = "UPDATE bill SET Status=? WHERE ID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, bill.getStatus());
                pstmt.setInt(2, bill.getID());
                int ketqua = pstmt.executeUpdate();
                return ketqua;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Bill bill) {
        try (Connection con = Connect.getConnection()) {
            String sql = "DELETE FROM bill WHERE ID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, bill.getID());
                int ketqua = pstmt.executeUpdate();
                return ketqua;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Bill> selectAll() {
        ArrayList<Bill> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM bill";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int ID = rs.getInt("ID");
                    int CusID = rs.getInt("CusID");
                    int LapID = rs.getInt("LapID");
                    String Status = rs.getString("Status");
                    ketqua.add(new Bill(ID,CusID,LapID,Status));
                }
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Bill selectById(Bill bill) {
        return null;
    }

    @Override
    public ArrayList<Bill> selectByCondition(String condition) {
        return null;
    }
}
