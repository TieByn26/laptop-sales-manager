package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private  static String username = "root";
    private static String password = "";
    public Connect() {
    }

    public static Connection getConnection() {
        Connection  connection = null;
        try{
            // dang ky driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


            String Url = "jdbc:mySQL://localhost:3306/QLBH?";

            // tao ket noi
            connection = DriverManager.getConnection(Url,username,password);
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection connection) {
        try{

            if(connection != null) {
                connection.close();
                System.out.println("ngắt kết nối thành công");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public  void setUsername(String username) {
        Connect.username = username;
    }

    public  void setPassword(String password) {
        Connect.password = password;
    }
}