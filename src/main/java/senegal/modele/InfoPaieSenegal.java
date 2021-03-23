package senegal.modele;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.InfoPaie;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @Data
public class InfoPaieSenegal extends InfoPaie {

    private double primeAssiduite;
    private double primeRestauration;
    private double impotRevenu;


    public InfoPaieSenegal(int id,
                           int employeId,
                           double nombreHeure,
                           double tauxHoraire,
                           double montantAvantage,
                           int heureSup,
                           double montantPret,
                           double primeAssiduite,
                           double primeRestauration,
                           double impotRevenu,
                           String periodePaie) {
        super(id, employeId, nombreHeure, tauxHoraire, montantAvantage, heureSup, montantPret, periodePaie);
        this.primeAssiduite = primeAssiduite;
        this.primeRestauration = primeRestauration;
        this.impotRevenu = impotRevenu;
    }
}
