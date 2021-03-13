package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data
public class InfoProfessionelle {

    protected String numMatricule;
    protected String statut;
    protected String poste;
    protected String ville;
    protected String contrat;
    protected String dateDebutContrat;
    protected String dateFinContrat;
    protected String departement;
    protected double salaireDeBase;
    protected String pays;

    private Employe employe;

    public InfoProfessionelle(String numMatricule, String statut, String poste, String ville, String contrat, String dateDebutContrat, String dateFinContrat, String departement, double salaireDeBase, String pays) {
        this.numMatricule = numMatricule;
        this.statut = statut;
        this.poste = poste;
        this.ville = ville;
        this.contrat = contrat;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        this.departement = departement;
        this.salaireDeBase = salaireDeBase;
        this.pays = pays;
    }


    @Override
    public String toString() {
        return "InfoProfessionelle{" +
                "numMatricule='" + numMatricule + '\'' +
                ", statut='" + statut + '\'' +
                ", poste='" + poste + '\'' +
                ", ville='" + ville + '\'' +
                ", contrat='" + contrat + '\'' +
                ", dateDebutContrat='" + dateDebutContrat + '\'' +
                ", dateFinContrat='" + dateFinContrat + '\'' +
                ", departement='" + departement + '\'' +
                ", salaireDeBase=" + salaireDeBase +
                ", pays='" + pays + '\'' +
                '}';
    }
}
