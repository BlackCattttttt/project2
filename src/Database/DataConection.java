package Database;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class DataConection {
	private static Connection con;
    private static String URL;
    private static String USER;
    private static String PASSWORD;
 
    public static Connection getConnection() {
        con = null;
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(new File("E:\\Java\\eclipse\\Project2\\Resources\\dataConfig.properties")));
            URL = properties.getProperty("url");
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");
            // driver register
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(DataConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (con);
    }
 
    public static void freeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
