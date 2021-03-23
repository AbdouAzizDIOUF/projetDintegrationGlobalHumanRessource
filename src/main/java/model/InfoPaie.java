package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data
public class InfoPaie {

    protected int id;
    private int employeId;
    protected double nombreHeure;
    protected double tauxHoraire;
    protected double montantAvantage;
    protected int heureSup;
    protected double montantPret;
    protected String periodePaie;



    public InfoPaie(
            int id,
            int employeId,
            double nombreHeure,
            double tauxHoraire,
            double montantAvantage,
            int heureSup,
            double montantPret,
            String periodePaie) {
        this.id = id;
        this.employeId = employeId;
        this.nombreHeure = nombreHeure;
        this.tauxHoraire = tauxHoraire;
        this.montantAvantage = montantAvantage;
        this.heureSup = heureSup;
        this.montantPret = montantPret;
        this.periodePaie = periodePaie;
    }


    @Override
    public String toString() {
        return "InfoPaie{" +
                "id=" + id +
                "employeId="+employeId +
                ", nombreHeure=" + nombreHeure +
                ", tauxHoraire=" + tauxHoraire +
                ", montantAvantage=" + montantAvantage +
                ", heureSup=" + heureSup +
                ", montantPret=" + montantPret +
                ", periodePaie=" +periodePaie;
    }
}
