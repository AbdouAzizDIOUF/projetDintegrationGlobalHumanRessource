package chine.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.Salaire;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @Data
public class SalaireChine extends Salaire {

    private double primeRisque;
    private double primeAncienete;

    public SalaireChine(String matricule, String nom, String prenom, Double nombreHeure, int heureSup, double avantage, double pret, double salaire, String periodePaie, double primeRisque, double primeAncienete, String pays) {
        super(matricule, nom, prenom, nombreHeure, heureSup, avantage, pret, salaire, periodePaie, pays);
        this.primeRisque = primeRisque;
        this.primeAncienete = primeAncienete;
    }

    @Override
    public String toString() {
        return super.toString() +
                "primeRisque=" + primeRisque +
                ", primeAncienete=" + primeAncienete +
                '}';
    }
}
