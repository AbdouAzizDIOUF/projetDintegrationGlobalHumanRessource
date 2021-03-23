package france.model;


import lombok.*;
import model.Salaire;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor @Data
public class SalaireFrance extends Salaire {

    private double indTransport;
    private double indMatrimoniale;



    public SalaireFrance(String matricule, String nom, String prenom, Double nombreHeure, int heureSup, double avantage, double pret, double salaire, String periodePaie, double indTransport, double indMatrimoniale, String pays) {
        super(matricule, nom, prenom, nombreHeure, heureSup, avantage, pret, salaire, periodePaie, pays);
        this.indTransport = indTransport;
        this.indMatrimoniale = indMatrimoniale;
    }

    @Override
    public String toString() {
        return super.toString() +
                "indTransport=" + indTransport +
                ", indMatrimoniale=" + indMatrimoniale +
                '}';
    }
}
