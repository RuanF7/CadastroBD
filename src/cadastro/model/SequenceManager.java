/**
 *
 * @author ruanf
 */

package cadastro.model;
import java.sql.ResultSet;
import java.sql.Statement;

/*Criando o sequenceManager*/
public class SequenceManager {

    private final ConectorBD conectorBD; 

    public SequenceManager() {
        this.conectorBD = new ConectorBD(); 
    }

    public int getValue(String sequenceName) throws java.sql.SQLException {
        int nextValue = 0; 
        String sql = "SELECT nextval('" + sequenceName + "')"; 
        ResultSet rs = null; 
        Statement statement = null; 

        statement = conectorBD.getStatement(); 
        rs = statement.executeQuery(sql); 
        if (rs.next()) { 
            nextValue = rs.getInt(1); 
        }
        conectorBD.close(rs); 
        conectorBD.close(statement); 

        return nextValue; 
    }
}
