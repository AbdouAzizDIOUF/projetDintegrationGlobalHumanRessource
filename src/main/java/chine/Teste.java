package chine;

import chine.database.DbConnexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (createTableEmploye()==1){
            System.out.println("table creer");
        }else{
            System.out.println("table not create");
        }

    }

    private static int createTableEmploye() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;

        String sql = """
        CREATE TABLE teste1 (
            id INT NOT NULL PRIMARY KEY auto_increment, 
            nom VARCHAR(255), 
            prenom VARCHAR(255),
            age int
            ); 
        """;
        preparedStatement = DbConnexion.getPreparedStatement(sql);
        return preparedStatement.executeUpdate();
    }
}
