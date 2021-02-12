package chine.dao;

import chine.database.DbConnexion;
import chine.model.EmployeChine;
import model.Employe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IDaoFunctionImpl implements IDaoFunction {

    public ResultSet resultSet = null;
    private PreparedStatement preparedStatement;

    /**
     * Methode de teste pour obtenir le nombre total d'employes
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int testeFunction() throws SQLException, ClassNotFoundException {
        preparedStatement = DbConnexion.getPreparedStatement("SELECT COUNT(*) AS NB_EMPLOYES FROM employe");
        resultSet = preparedStatement.executeQuery();

        return resultSet.getInt("NB_EMPLOYES");
    }


    @Override
    public Double moyenSalaire() {
        return null;
    }

    @Override
    public int nombreEmployer() {
        return 0;
    }

    @Override
    public Double salaireMax() {
        return null;
    }

    @Override
    public Double totalSalire() {
        return null;
    }

    @Override
    public EmployeChine minSalireEmploye() {
        return null;
    }

    @Override
    public EmployeChine maxSalireEmploye() {
        return null;
    }

    @Override
    public List<Employe> listeEmployes() {
        return null;
    }
}
