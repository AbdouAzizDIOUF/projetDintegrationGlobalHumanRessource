package senegal;

import senegal.dao.IDaoFunction;
import senegal.dao.IDaoFunctionImpl;
import senegal.database.DbConnexion;
import senegal.modele.EmployeSenegal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teste {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        IDaoFunctionImpl dao = new IDaoFunctionImpl();

        EmployeSenegal emp = dao.maxSalireEmploye();
        System.out.println(emp.getId());
        System.out.println(emp.getPrenom());
        System.out.println(emp.getNom());
       /* List<EmployerSenegal> listeemp = dao.listeEmployes();
        for (EmployerSenegal employeSenegal : listeemp) {
            System.out.println(employeSenegal.getId());
            System.out.println(employeSenegal.getNom());
            System.out.println(employeSenegal.getPrenom());
        }*/




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
            create Table InfoPaie (id SERIAL Primary Key NOT NULL,
            employe int,
            nombreHeure float,
            tauxHoraire float,
            montantAvantage float,
            heureSup int,
            montantPret float,
            primeAssiduite float,
            primeRestauration float,
            impotRevenu float,
            periodePaie varchar(255),
            Foreign key (employe) References EmployeSenegal(id))
            """;
        preparedStatement = DbConnexion.getPreparedStatement(sql);

        return preparedStatement.executeUpdate();
    }


    private static int createInfoProfessionnelle() throws SQLException, ClassNotFoundException {
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
            Foreign key (employe) References EmployeSenegal(id))
            """;
        preparedStatement = DbConnexion.getPreparedStatement(sql);

        return preparedStatement.executeUpdate();
    }

}
