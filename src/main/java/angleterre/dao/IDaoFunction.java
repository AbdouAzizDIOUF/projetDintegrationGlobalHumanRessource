package angleterre.dao;

import angleterre.model.EmployeAngleterre;
import angleterre.model.Salaire;
import chine.model.EmployeChine;
import model.Employe;

import java.io.IOException;
import java.util.List;

public interface IDaoFunction {

    Double moyenSalaire() throws IOException;

    int nombreEmployer() throws IOException;

    Double salaireMax() throws IOException;

    Double totalSalaire() throws IOException;

    Salaire minSalaireEmploye() throws IOException;

    Salaire maxSalaireEmploye() throws IOException;

    List<EmployeAngleterre> listeEmployes() throws IOException;

    List<Salaire> listeSalaires() throws IOException;
}
