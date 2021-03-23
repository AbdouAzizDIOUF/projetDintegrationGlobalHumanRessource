package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Salaire implements Comparable<Salaire> {

    protected String matricule;
    protected String nom;
    protected String prenom;
    protected Double nombreHeure;
    protected int heureSup;
    protected double avantage;
    protected double pret;
    protected double salaire;
    protected String periodePaie;
    protected String pays;


    @Override
    public String toString() {
        return "Salaire{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nombreHeure=" + nombreHeure +
                ", heureSup=" + heureSup +
                ", avantage=" + avantage +
                ", pret=" + pret +
                ", salaire=" + salaire +
                ", periodePaie='" + periodePaie + '\''+
                ", pays='" + pays + '\'';
    }

    @Override
    public int compareTo(Salaire o) {
        return  (int)(this.salaire - o.getSalaire());
    }
}
