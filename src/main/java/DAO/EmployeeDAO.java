package DAO;

import ConnectDB.Connect;
import Model.Personn.Customers;
import Model.Personn.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO implements DAOinterface<Employee>{
    @Override
    public int insert(Employee employee) {
        try (Connection con = Connect.getConnection()) {
            String sql = "INSERT INTO Customer(CusID, Name, Address, Gender, Phone, Salary) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, employee.getEmpId());
                pstmt.setString(2, employee.getName());
                pstmt.setString(3, employee.getAddress());
                pstmt.setString(4, employee.getGender());
                pstmt.setString(5, employee.getPhone());
                pstmt.setDouble(6,employee.getSalary());

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
    public int update(Employee employee) {
        try (Connection con = Connect.getConnection()) {
            String sql = "UPDATE Customer SET Name=?, Address=?, Gender=?, Phone=?, Salary=? WHERE CusID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, employee.getName());
                pstmt.setString(2, employee.getAddress());
                pstmt.setString(3, employee.getGender());
                pstmt.setString(4, employee.getPhone());
                pstmt.setInt(5, employee.getEmpId());

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
    public int delete(Employee employee) {
        try (Connection con = Connect.getConnection()) {
            String sql = "DELETE FROM Customer WHERE CusID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, employee.getEmpId());

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
    public ArrayList<Employee> selectAll() {
        ArrayList<Employee> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM Employee";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int EmpID = rs.getInt("EmpID");
                    String Name = rs.getString("Name");
                    String Address = rs.getString("Address");
                    String Gender = rs.getNString("Gender");
                    String Phone = rs.getString("Phone");
                    Double Salary = rs.getDouble("Salary");

                    Employee emp = new Employee(EmpID, Name, Address, Gender, Phone, Salary);
                    ketqua.add(emp);
                }
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Employee selectById(Employee employee) {
        Employee ketqua = null;
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM customer WHERE CusID=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1,employee.getEmpId());
                ResultSet rs = pstmt.executeQuery();
                int EmpID = rs.getInt("EmpID");
                String Name = rs.getString("Name");
                String Address = rs.getString("Address");
                String Gender = rs.getString("Gender");
                String Phone = rs.getString("Phone");

                Double Salary = rs.getDouble("Salary");

                ketqua = new Employee(EmpID, Name, Address, Gender, Phone, Salary);
            }
            Connect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<Employee> selectByCondition(String condition) {
        return null;
    }
}
