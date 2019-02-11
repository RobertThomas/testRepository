import com.mysql.cj.x.protobuf.MysqlxExpr;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    private Connection con;
    private Statement st;
    private String firstNameCheck;
    private ArrayList arResults = new ArrayList();


    public static void main(String[] args) {


    }

    public static void testRefactor()
    {
        System.out.println("Test");
    }

    public Statement connect()
    {
        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root", "password");
            Statement st = con.createStatement();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return st;
    }

    public String doQuery()
    {
        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root", "password");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * from user.user WHERE user.user.firstname = 'bob'");

            while (rs.next()){
           /*     System.out.println("----------------------");
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                if(rs.getString(2).equals("bob"))
                    System.out.println("This is bob");
                System.out.println("----------------------");
*/
                for(int i = 0; i < rs.getFetchSize(); i++){
                    arResults.add(rs.getString(i));
                }

            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return arResults.toString();
    }

    public  void findBoB(){
        System.out.println(doQuery());
    }
}
