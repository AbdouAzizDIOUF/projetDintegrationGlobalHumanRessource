package senegal.modele;


import lombok.NoArgsConstructor;
import model.Employe;
@NoArgsConstructor
public class EmployeSenegal extends Employe {


    public EmployeSenegal(int id, String nom, String prenom, int age, String sexe, String telephone, String email, String adresse) {
        super(id, nom, prenom, age, sexe, telephone, email, adresse);
    }
}
