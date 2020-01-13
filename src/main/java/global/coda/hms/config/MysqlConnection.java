package global.coda.hms.config;

import global.coda.hms.constant.dbconstant.ConnectionConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author VC
 */
public class MysqlConnection {
    private Connection connection;
    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());
    private static String connectionUrl = LOCAL_MESSAGES_BUNDLE.getString(ConnectionConstant.CONNECTION_URL);
    private static String username = LOCAL_MESSAGES_BUNDLE.getString(ConnectionConstant.CONNECTION_USERNAME);
    private static String password = LOCAL_MESSAGES_BUNDLE.getString(ConnectionConstant.CONNECTION_PASSWORD);


    /**
     * handles the DB Connection.
     *
     * @throws SQLException handles the SQL exception.
     */
    public MysqlConnection() throws SQLException {

        connection = DriverManager.getConnection(connectionUrl, username, password);

    }

    /**
     * Get Connection.
     *
     * @return gives the connection.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * CLose the Connection.
     *
     * @throws SQLException handles the Sql Exception.
     */
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
