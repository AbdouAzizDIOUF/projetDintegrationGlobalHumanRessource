package angleterre.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.InfoProfessionelle;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @Data
public class InfoProfessionelAngleterre extends InfoProfessionelle {

    private int employeId;

    public InfoProfessionelAngleterre(
            String numMatricule,
            int employeId,
            String statut,
            String poste,
            String ville,
            String contrat,
            String dateDebutContrat,
            String dateFinContrat,
            String departement,
            double salaireDeBase,
            String pays) {
        super(numMatricule, statut, poste, ville, contrat, dateDebutContrat, dateFinContrat, departement, salaireDeBase, pays);
        this.employeId = employeId;
    }

    @Override
    public String toString() {
        return "InfoProfessionelAngleterre{" +
                "employeId=" + employeId +
                ", numMatricule='" + numMatricule + '\'' +
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
