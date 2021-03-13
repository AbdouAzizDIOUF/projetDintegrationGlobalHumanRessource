package chine.database;

import java.sql.*;

public class DbConnexion {

    private static Connection connection = null;

    /**
     * Obtenire la connexion a la base de donnees
     *
     * @return Connection
     * @throws SQLException Connexion non etablie
     * @throws ClassNotFoundException Drive non present
     */
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        if (connection==null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://immo-agence.fr:3306/projet", "projet", "projet");
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
