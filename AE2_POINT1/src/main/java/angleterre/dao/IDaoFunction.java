package angleterre.dao;

import angleterre.model.EmployeAngleterre;
import chine.model.EmployeChine;
import model.Employe;

import java.io.IOException;
import java.util.List;

public interface IDaoFunction {

    Double moyenSalaire();

    int nombreEmployer();

    Double salaireMax();

    Double totalSalire();

    EmployeChine minSalireEmploye();

    EmployeChine maxSalireEmploye();

    List<EmployeAngleterre> listeEmployes() throws IOException;

}
