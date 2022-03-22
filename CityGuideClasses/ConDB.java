package CityGuideClasses;
import java.sql.*;

public class ConDB {
    Connection c;
    Statement s;
    ConDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cityguide","root","root");
            s = c.createStatement();
        }catch(Exception e){}
    }
}
