package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data
public class InfoPaie {

    protected int id;
    protected double nombreHeure;
    protected double tauxHoraire;
    protected double montantAvantage;
    protected int heureSup;
    protected double montantPret;
    protected String periodePaie;

    protected Employe employe;


    public InfoPaie(int id, double nombreHeure, double tauxHoraire, double montantAvantage, int heureSup, double montantPret) {
        this.id = id;
        this.nombreHeure = nombreHeure;
        this.tauxHoraire = tauxHoraire;
        this.montantAvantage = montantAvantage;
        this.heureSup = heureSup;
        this.montantPret = montantPret;
    }


    @Override
    public String toString() {
        return "InfoPaie{" +
                "id=" + id +
                ", nombreHeure=" + nombreHeure +
                ", tauxHoraire=" + tauxHoraire +
                ", montantAvantage=" + montantAvantage +
                ", heureSup=" + heureSup +
                ", montantPret=" + montantPret +
                '}';
    }
}
