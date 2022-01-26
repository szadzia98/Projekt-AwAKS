package listApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;


public class DBConnection {
    private Map<String, String> env = System.getenv();
    public String select(int id){
        Statement stmt = null;
        Connection c = null;
        String lista = "";
        try {
            String url = env.get("DB_URL");
            c = DriverManager
                    .getConnection(url, env.get("USER_DB"), env.get("PASSWORD_DB"));

            stmt = c.createStatement();

            String psqlStatment = "SELECT * FROM przepisy WHERE id = '" + id + "'";
            ResultSet rs = stmt.executeQuery(psqlStatment);
            while (rs.next()){
                lista = rs.getString("skladniki");
                }
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return lista;
}}
