package angleterre.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import model.Employe;

@NoArgsConstructor
public class EmployeAngleterre extends Employe implements Comparable<EmployeAngleterre> {
    public EmployeAngleterre(
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
    public int compareTo(EmployeAngleterre emp) {
        return (this.age - emp.getAge());
    }
}
