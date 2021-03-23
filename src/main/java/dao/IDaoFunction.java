package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDaoFunction <Emp, Prof, Paie, Sal> {

    List<Emp> getEmployees() throws IOException, SQLException, ClassNotFoundException;
    List<Prof> getInfoProffs() throws IOException, SQLException, ClassNotFoundException;
    int getNombreEmployer() throws IOException, SQLException, ClassNotFoundException;
    List<Paie> getInfoPaiesByMounth(String date) throws IOException, SQLException, ClassNotFoundException;
    List<Sal> getSalairesByMounth(String date) throws IOException, SQLException, ClassNotFoundException;
    Sal minSalaireEmployeByMounth(String date) throws IOException, SQLException, ClassNotFoundException;
    Sal maxSalaireEmployeByMounth(String date) throws IOException, SQLException, ClassNotFoundException;
    double moyenSalaireMounth(String date) throws IOException, SQLException, ClassNotFoundException;
    double getBudgetTotal(String date) throws IOException, SQLException, ClassNotFoundException;

    double pourcentageHomme() throws IOException, SQLException, ClassNotFoundException;
    double pourcentageFeminin() throws IOException, SQLException, ClassNotFoundException;
    double pourcentageOuvriers() throws IOException, SQLException, ClassNotFoundException;
    double pourcentageCadres() throws IOException, SQLException, ClassNotFoundException;
}
