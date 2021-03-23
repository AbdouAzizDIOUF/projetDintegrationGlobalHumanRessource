package france.model;

import lombok.*;
import model.InfoProfessionelle;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @Data
public class InfoProfessionelFrance extends InfoProfessionelle {
   private String matrimoniale;

    public InfoProfessionelFrance(String numMatricule, int employeId,String statut, String poste, String ville, String contrat, String dateDebutContrat, String dateFinContrat, String departement, double salaireDeBase, String pays, String matrimoniale) {
        super(numMatricule, employeId, statut, poste, ville, contrat, dateDebutContrat, dateFinContrat, departement, salaireDeBase, pays);
        this.matrimoniale = matrimoniale;
    }

    @Override
    public String toString() {
        return super.toString() +
                "matrimoniale='" + matrimoniale +
                '}';
    }
}
