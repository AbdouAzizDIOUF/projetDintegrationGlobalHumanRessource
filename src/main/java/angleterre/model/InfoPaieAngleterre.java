package angleterre.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.InfoPaie;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class InfoPaieAngleterre extends InfoPaie {

    private double indLogement;
    private double indTransport;

    public InfoPaieAngleterre(int id,
                              int employeId,
                              double nombreHeure,
                              double tauxHoraire,
                              double montantAvantage,
                              int heureSup,
                              double montantPret,
                              double indLogement,
                              double indTransport,
                              String periodePaie) {
        super(id, employeId, nombreHeure, tauxHoraire, montantAvantage, heureSup, montantPret, periodePaie);
        this.indLogement = indLogement;
        this.indTransport = indTransport;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "indLogement=" + indLogement +
                ", indTransport=" + indTransport +
                '}';
    }
}
