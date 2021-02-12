package chine.dao;

import chine.model.EmployeChine;
import model.Employe;
import senegal.modele.EmployeSenegal;

import java.util.List;

public interface IDaoFunction {

    Double moyenSalaire();

    int nombreEmployer();

    Double salaireMax();

    Double totalSalire();

    EmployeChine minSalireEmploye();

    EmployeChine maxSalireEmploye();

    List<Employe> listeEmployes();
}
