package przepisnikApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBConnection {
    private Map<String, String> env = System.getenv();
    public List<String> select(){
        Statement stmt = null;
        Connection c = null;
        List<String> lista = new ArrayList<String>();
        int i = 0;
        try {
            String url = env.get("DB_URL");
            c = DriverManager
                    .getConnection(url, env.get("USER_DB"), env.get("PASSWORD_DB"));

            stmt = c.createStatement();

            String psqlStatment = "SELECT nazwa FROM przepisy";
            ResultSet rs = stmt.executeQuery(psqlStatment);
            while (rs.next()){
                lista.add(rs.getString("nazwa")) ;

            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }

        return lista;
}
}
