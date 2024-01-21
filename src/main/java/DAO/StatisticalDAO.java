package DAO;

import ConnectDB.Connect;
import Model.Laptop.Statistical;
import Model.Personn.Customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatisticalDAO implements DAOinterface<Statistical>{
    public static StatisticalDAO getStatisticalDAO(){
        return new StatisticalDAO();
    }
    @Override
    public int insert(Statistical statistical) {
        return 0;
    }

    @Override
    public int update(Statistical statistical) {
        try (Connection con = Connect.getConnection()) {
            String sql = "UPDATE statistical SET SSPbanduoc=?, Tienkiemduoc=?, Tongtien=? WHERE ID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, statistical.getSoluongspdaban());
                pstmt.setDouble(2, statistical.getTienkiemduoc());
                pstmt.setDouble(3, statistical.getTongtien());
                pstmt.setInt(4, statistical.getID());
                int ketqua = pstmt.executeUpdate();
                return ketqua;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Statistical statistical) {
        return 0;
    }

    @Override
    public ArrayList<Statistical> selectAll() {
        ArrayList<Statistical> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM statistical";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    int sspbanduoc = rs.getInt("SSPbanduoc");
                    Double tienkiemduoc = rs.getDouble("Tienkiemduoc");
                    Double tongtien = rs.getDouble("Tongtien");

                    ketqua.add(new Statistical(id,sspbanduoc,tienkiemduoc,tongtien));
                }
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public Statistical select() {
        Statistical ketqua = null;
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM statistical";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    int sspbanduoc = rs.getInt("SSPbanduoc");
                    Double tienkiemduoc = rs.getDouble("Tienkiemduoc");
                    Double tongtien = rs.getDouble("Tongtien");

                    ketqua = new Statistical(id,sspbanduoc,tienkiemduoc,tongtien);
                }
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Statistical selectById(Statistical statistical) {
        return null;
    }

    @Override
    public ArrayList<Statistical> selectByCondition(String condition) {
        return null;
    }
}
