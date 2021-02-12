package senegal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnexion {

    private static final PreparedStatement preparedStatement = null;
    private static Connection connection = null;


    /**
     * Obtenire la connexion a la base de donnees
     *
     * @return Connection
     * @throws SQLException Connexion non etablie
     * @throws ClassNotFoundException Drive non present
     */
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        if (connection==null){
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://82.165.203.171:5432/projet", "projet", "projet");
            System.out.println("connexion a la base de donnees etablie avec succee");
        }

        return connection;
    }

    /**
     * Pour Concevoir la requette sql
     *
     * @param req la requete sql
     * @return retourne un objet de type {@link PreparedStatement}
     * @throws SQLException exception liee au code sql
     * @throws ClassNotFoundException exception liee au drive
     */
    public static PreparedStatement getPreparedStatement(String req) throws SQLException, ClassNotFoundException {
        return getDbConnection().prepareStatement(req);
    }

}
