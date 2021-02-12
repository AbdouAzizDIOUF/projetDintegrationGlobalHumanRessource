package angleterre.model;

import lombok.NoArgsConstructor;
import model.InfoProfessionelle;

@NoArgsConstructor
public class InfoProfessionelAngleterre extends InfoProfessionelle {

    public InfoProfessionelAngleterre(
            String numMatricule,
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
    }
}
