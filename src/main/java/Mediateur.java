import angleterre.dao.IDaoFunctionImplAngletterre;
import chine.dao.IDaoFunctionImplChine;
import com.graphbuilder.math.func.EFunction;
import france.dao.IDaoFunctionImplFrance;
import model.Salaire;
import senegal.dao.IDaoFunctionImplSenegal;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mediateur {

    private IDaoFunctionImplFrance france;
    private IDaoFunctionImplAngletterre angleterre;
    private IDaoFunctionImplSenegal senegal;
    private IDaoFunctionImplChine chine;


    public Mediateur(){
        this.france = new IDaoFunctionImplFrance();
        this.angleterre = new IDaoFunctionImplAngletterre();
        this.senegal = new IDaoFunctionImplSenegal();
        this.chine = new IDaoFunctionImplChine();
    }


    public int getNombreEmployes() throws IOException, SQLException, ClassNotFoundException {
        return this.angleterre.getNombreEmployer()+this.france.getNombreEmployer()+this.senegal.getNombreEmployer()+this.chine.getNombreEmployer();
    }

    public double getPourcentageFemme() throws IOException, SQLException, ClassNotFoundException {
        return this.angleterre.pourcentageFeminin()+this.france.pourcentageFeminin()+this.senegal.pourcentageFeminin()+this.chine.pourcentageFeminin();
    }

    public double getPourcentageHomme() throws IOException, SQLException, ClassNotFoundException {
        return this.angleterre.pourcentageHomme()+this.france.pourcentageHomme()+this.senegal.pourcentageHomme()+this.chine.pourcentageHomme();
    }

    public double getPourcentageCadres() throws IOException, SQLException, ClassNotFoundException {
        return this.angleterre.pourcentageCadres()+this.france.pourcentageCadres()+this.senegal.pourcentageCadres()+this.chine.pourcentageCadres();
    }

    public double getPourcentageOuvrier() throws IOException, SQLException, ClassNotFoundException {
        return this.angleterre.pourcentageOuvriers()+this.france.pourcentageOuvriers()+this.senegal.pourcentageOuvriers()+this.chine.pourcentageOuvriers();
    }

    public double getBudgetTotal(String date) throws IOException, SQLException, ClassNotFoundException {
        return this.angleterre.getBudgetTotal(date)+this.france.getBudgetTotal(date)+this.senegal.getBudgetTotal(date)+ chine.getBudgetTotal(date);
    }

    public List<Salaire> getEmployesMaxSalaires(String date) throws IOException, SQLException, ClassNotFoundException {
        List<Salaire> salairies = new ArrayList<>();
        salairies.add(this.angleterre.maxSalaireEmployeByMounth(date));
        salairies.add(this.france.maxSalaireEmployeByMounth(date));
        salairies.add(this.senegal.maxSalaireEmployeByMounth(date));
        salairies.add(this.chine.maxSalaireEmployeByMounth(date));

        return salairies;
    }

    public List<Salaire> getEmployesMinSalaires(String date) throws IOException, SQLException, ClassNotFoundException {
        List<Salaire> salairies = new ArrayList<>();
        salairies.add(this.angleterre.minSalaireEmployeByMounth(date));
        salairies.add(this.france.minSalaireEmployeByMounth(date));
        salairies.add(this.senegal.minSalaireEmployeByMounth(date));
        salairies.add(this.chine.minSalaireEmployeByMounth(date));

        return salairies;
    }

    public List getSalairesEmployes(String pays, String date) throws IOException, SQLException, ClassNotFoundException {

        return switch(pays){
            case "Angleterre" -> angleterre.getSalairesByMounth(date);
            case "France" -> france.getSalairesByMounth(date);
            case "Chine" -> chine.getSalairesByMounth(date);
            case "Senegal" -> senegal.getSalairesByMounth(date);
            default -> this.getEmployesMaxSalaires(date);
        };
    }


}
