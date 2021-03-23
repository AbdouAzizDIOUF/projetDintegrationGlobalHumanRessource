package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor @Data
public class Employe {

    protected int id;
    protected String nom;
    protected String prenom;
    protected int age;
    protected String sexe;
    protected String telephone;
    protected String email;
    protected String adresse;


    protected List<InfoPaie> listeInfoPaies;

    public Employe(int id, String nom, String prenom, int age, String sexe, String telephone, String email, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", sexe='" + sexe + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
