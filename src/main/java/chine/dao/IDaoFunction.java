package chine.dao;

import chine.model.EmployeChine;

import java.sql.SQLException;
import java.util.List;

public interface IDaoFunction {

    Double moyenSalaire() throws SQLException, ClassNotFoundException;

    int nombreEmployer() throws SQLException, ClassNotFoundException;

    Double salaireMax() throws SQLException, ClassNotFoundException;

    Double totalSalire() throws SQLException, ClassNotFoundException;

    EmployeChine minSalireEmploye() throws SQLException, ClassNotFoundException;

    EmployeChine maxSalireEmploye() throws SQLException, ClassNotFoundException;

    List<EmployeChine> listeEmployes() throws SQLException, ClassNotFoundException;
}
