package france.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.Employe;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EmployerFrance extends Employe implements Comparable<EmployerFrance> {

    public EmployerFrance(
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
    public int compareTo(EmployerFrance o) {
        return (this.age - o.getAge());
    }
}
