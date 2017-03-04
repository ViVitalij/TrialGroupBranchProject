import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by k.czechowski83@gmail.com on 2017-03-04.
 */
public class ConnectToDB {

    public Connection makeConnekt() {
        String host = "jdbc:mysql://localhost:3306/NAZWABAZY?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "user";
        String password = "password";
        try {
            Connection con = DriverManager.getConnection(host, user, password);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
