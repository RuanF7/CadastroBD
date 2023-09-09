
/**
 *
 * @author ruanf
 */
package cadastro.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorBD {

    /* Conexão com o banco */
    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true";                   
        String user = "loja";
        String password = "loja";
        return DriverManager.getConnection(url, user, password);
    }

    /* Cria um PreparedStatement para executar uma consulta parametrizada */
    public PreparedStatement getPrepared(String sql) throws SQLException {
        Connection connection = getConnection();
        return connection.prepareStatement(sql);
    }

    /* Consulta SELECT e retorno ResultSet */
    public ResultSet getSelect(String sql) throws SQLException {
        Statement statement = getConnection().createStatement();
        return statement.executeQuery(sql);
    }
    
    /* Fechamento do objeto ResultSet */
    public void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
        }
    }

    /* Fechamento do objeto Statement */
    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
        }
    }
    

    /* Fechamento da conexão com o banco */
    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }

        Statement getStatement() {
         return null; 
     }

}
