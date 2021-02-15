package angleterre.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.InfoProfessionelle;

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
}
