package chine.model;


import lombok.NoArgsConstructor;
import model.Employe;
@NoArgsConstructor
public class EmployerChine extends Employe {

    public EmployerChine(
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
