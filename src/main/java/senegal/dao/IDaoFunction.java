package senegal.dao;

import senegal.modele.EmployeSenegal;

import java.sql.SQLException;
import java.util.List;

public interface IDaoFunction {

     Double moyenSalaire() throws SQLException, ClassNotFoundException;

     int nombreEmployer() throws SQLException, ClassNotFoundException;

     Double salaireMax() throws SQLException, ClassNotFoundException;

     Double totalSalire() throws SQLException, ClassNotFoundException;

     EmployeSenegal minSalireEmploye() throws SQLException, ClassNotFoundException;

     EmployeSenegal maxSalireEmploye() throws SQLException, ClassNotFoundException;

     List<EmployeSenegal> listeEmployes() throws SQLException, ClassNotFoundException;


}
