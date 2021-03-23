package angleterre.model;

import lombok.NoArgsConstructor;
import model.Employe;

@NoArgsConstructor
public class EmployerAngleterre extends Employe implements Comparable<EmployerAngleterre> {
    public EmployerAngleterre(
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

    @Override
    public int compareTo(EmployerAngleterre emp) {
        return (this.age - emp.getAge());
    }
}
