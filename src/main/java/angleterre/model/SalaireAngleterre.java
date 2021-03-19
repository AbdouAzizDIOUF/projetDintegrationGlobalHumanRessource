package angleterre.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Comparator;

@NoArgsConstructor @AllArgsConstructor @Data @ToString
public class Salaire implements Comparable<Salaire> {

    private String matricule;
    private String nom;
    private String prenom;
    private Double nombreHeure;
    private int heureSup;
    private Double avantage;
    private Double indLogement;
    private Double indTransport;
    private Double pret;
    private Double salaire;
    private String periodePaie;


    @Override
    public int compareTo(Salaire o) {
        return  (int)(this.salaire - o.getSalaire());
    }
}
