import java.sql.*;

/**
 * @Derscription TODO
 * @auther David
 * @date 2018/7/25 11:04
 * @Version 1.o
 */


public class JDBC {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //jdbc:mysql://106.37.227.30:3306/oms
    public static final String DBURL = "jdbc:mysql://106.37.227.30:3306/oms?useSSL=false&autoReconnect=true";

    public static final String DBUSER = "oms";

    public static final String PASSWORD = "oms";

    public static Connection connection = null;

    public static PreparedStatement preparedStatement = null;

    public static ResultSet resultSet = null;


    public static String getConnection() {
        try {
            Class.forName(DBDRIVER);
            DriverManager.setLoginTimeout(2);
            connection = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
            return "success";
        } catch (ClassNotFoundException e) {
            return "ClassNotFoundException";
        } catch (SQLException e) {
            return  e.toString();
        }
    }



    public static int getCount(String project_code) {
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) num FROM project WHERE project_code like '%"  + project_code + "%'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("num");
                System.out.println(count);
            }

            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }





    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}