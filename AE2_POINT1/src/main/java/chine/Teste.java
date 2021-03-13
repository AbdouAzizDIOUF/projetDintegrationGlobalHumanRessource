package chine;

import chine.dao.IDaoFunction;
import chine.dao.IDaoFunctionImpl;
import chine.database.DbConnexion;
import chine.model.EmployeChine;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        IDaoFunction dao = new IDaoFunctionImpl();
        double moyenne = dao.moyenSalaire();
        double totalsal = dao.totalSalire();
        int nbemp = dao.nombreEmployer();
        System.out.println("Moyenne \n: "+moyenne);
        System.out.println("totale salaire \n: "+totalsal);
        System.out.println("nomreemploye \n: "+nbemp);
    }

    private static int createTableEmployeChine() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;

        String sql = """
            create Table EmployeChine (
                id int Primary key NOT NULL AUTO_INCREMENT,
                nom varchar(255),
                prenom varchar(255),
                age int,
                sexe varchar(255),
                telephone varchar(255),
                email varchar(255),
                adresse varchar(255))
        """;
        preparedStatement = DbConnexion.getPreparedStatement(sql);
        return preparedStatement.executeUpdate();
    }
    private static int createTableInfoPaie() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;

        String sql = """
            create Table InfoPaie (id SERIAL Primary Key NOT NULL,
            employe int,
            nombreHeure float,
            tauxHoraire float,
            montantAvantage float,
            heureSup int,
            montantPret float,
            primeRisque float,
            primeAnciennete float,
            periodePaie varchar(255),
            Foreign key (employe) References EmployeChine(id))
            """;
        preparedStatement = DbConnexion.getPreparedStatement(sql);
        return preparedStatement.executeUpdate();
    }

    private static int createTableInfoProfessionnelle() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        String sql = """
            create Table InfoProfessionnelle(
            id SERIAL Primary key NOT NULL,
            employe int,
            numMatricule varchar(255),
            statut varchar(255),
            poste varchar(255),
            ville varchar(255),
            contrat varchar(255),
            dateDebutContrat date,
            dateFinContrat date,
            departement varchar(255),
            salaireDeBase float,
            pays varchar(255),
            Foreign key (employe) References EmployeChine(id))
            """;
        preparedStatement = DbConnexion.getPreparedStatement(sql);

        return preparedStatement.executeUpdate();
    }
}
