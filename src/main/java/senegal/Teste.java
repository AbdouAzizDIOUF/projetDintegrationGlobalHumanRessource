package senegal;

import dao.IDaoFunction;
import senegal.dao.IDaoFunctionImplSenegal;
import senegal.database.DbConnexion;
import senegal.modele.EmployerSenegal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {


        IDaoFunctionImplSenegal dao = new IDaoFunctionImplSenegal();

        //System.out.println(dao.getNombreEmployer());

        createInfoProfessionnelle();
        createInfoPaie();


    }

    private static int createEmployeSenegal() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        String sql = """
            create Table EmployeSenegal (
                id SERIAL Primary key NOT NULL,
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


    private static int createInfoPaie() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        String sql = """
            create Table InfoPaieSenegal (
            id SERIAL Primary Key NOT NULL,
            employeId int,
            nombreHeure float,
            tauxHoraire float,
            montantAvantage float,
            heureSup int,
            montantPret float,
            primeAssiduite float,
            primeRestauration float,
            impotRevenu float,
            periodePaie varchar(255),
            Foreign key (employeId) References EmployerSenegal(id))
            """;
        preparedStatement = DbConnexion.getPreparedStatement(sql);

        return preparedStatement.executeUpdate();
    }


    private static int createInfoProfessionnelle() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        String sql = """
            create Table InfoProfessionnelle(
            numMatricule varchar(255) PRIMARY KEY NOT NULL,
            employeId int,
            statut varchar(255),
            poste varchar(255),
            ville varchar(255),
            contrat varchar(255),
            dateDebutContrat varchar(255),
            dateFinContrat varchar(255),
            departement varchar(255),
            salaireDeBase float,
            pays varchar(255),
            Foreign key (employeId) References EmployerSenegal(id)
            )
            """;
        preparedStatement = DbConnexion.getPreparedStatement(sql);

        return preparedStatement.executeUpdate();
    }

}
