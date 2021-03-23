package senegal.modele;


import lombok.NoArgsConstructor;
import model.Employe;
@NoArgsConstructor
public class EmployerSenegal extends Employe {
    public EmployerSenegal(
            int id,
            String nom,
            String prenom,
            int age,
            String sexe,
            String telephone,
            String email,
            String adresse) {
        super(id, nom, prenom, age, sexe, telephone, email, adresse);
    }
}
