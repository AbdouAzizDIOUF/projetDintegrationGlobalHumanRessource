package france.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import model.InfoPaie;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @Data
public class InfoPaieFrance extends InfoPaie {

    private double indTransport;
    private double indMatrimoniale;

    public InfoPaieFrance(
            int id,
            int employeId,
            double nombreHeure,
            double tauxHoraire,
            double montantAvantage,
            int heureSup,
            double montantPret,
            double indTransport,
            double indMatrimoniale,
            String periodePaie
            ) {
        super(id,employeId,nombreHeure, tauxHoraire, montantAvantage, heureSup, montantPret, periodePaie);
        this.indTransport = indTransport;
        this.indMatrimoniale = indMatrimoniale;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "indTransport=" + indTransport +
                ", indMatrimoniale=" + indMatrimoniale +
                '}';
    }
}
