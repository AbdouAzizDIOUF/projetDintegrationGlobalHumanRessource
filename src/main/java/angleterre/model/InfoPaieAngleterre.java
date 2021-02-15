package angleterre.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.InfoPaie;

@NoArgsConstructor
@Data
public class InfoPaieAngleterre extends InfoPaie {

    private Double indLogement;
    private Double indTransport;
    private String periodePaie;
    private int employeId;

    public InfoPaieAngleterre(
            int id,
            int employeId,
            double nombreHeure,
            double tauxHoraire,
            double montantAvantage,
            int heureSup,
            double montantPret,
            Double indLogement,
            Double indTransport,
            String periodePaie
            )
    {
        super(id, nombreHeure, tauxHoraire, montantAvantage, heureSup, montantPret);
        this.employeId = employeId;
        this.indLogement = indLogement;
        this.indTransport = indTransport;
        this.periodePaie = periodePaie;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "indLogement=" + indLogement +
                ", indTransport=" + indTransport +
                ", periodePaie='" + periodePaie + '\'' +
                '}';
    }
}
