package chine.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.InfoPaie;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @Data
public class InfoPaieChine extends InfoPaie {

    private double primeRisque;
    private double primeAnciennete;

    public InfoPaieChine(
            int id,
            int employeId,
            double nombreHeure,
            double tauxHoraire,
            double montantAvantage,
            int heureSup,
            double montantPret,
            double primeRisque,
            double primeAnciennete,
            String periodePaie) {
        super(id, employeId, nombreHeure, tauxHoraire, montantAvantage, heureSup, montantPret, periodePaie);
        this.primeRisque = primeRisque;
        this.primeAnciennete = primeAnciennete;
    }

}
