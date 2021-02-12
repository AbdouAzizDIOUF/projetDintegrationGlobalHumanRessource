package angleterre.model;

import model.InfoPaie;

public class InfoPaieAngleterre extends InfoPaie {

    private Double indLogement;
    private Double indTransport;
    private String periodePaie;

    public InfoPaieAngleterre(
            int id,
            double nombreHeure,
            double tauxHoraire,
            double montantAvantage,
            int heureSup,
            double montantPret,
            Double indLogement,
            Double indTransport,
            String periodePaie)
    {
        super(id, nombreHeure, tauxHoraire, montantAvantage, heureSup, montantPret);
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
