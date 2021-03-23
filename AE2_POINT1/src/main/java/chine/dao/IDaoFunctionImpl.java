package chine.dao;

import chine.model.EmployeChine;
import chine.database.DbConnexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IDaoFunctionImpl implements IDaoFunction {

    public ResultSet resultSet = null;
    private PreparedStatement preparedStatement;

    /**
     * Methode de Teste pour obtenir le nombre total d'employes
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Double>listeSalaires() throws SQLException, ClassNotFoundException {
        List<Double> listeDesSalaires = new ArrayList();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM InfoPaie");
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            int nombreHeurs = resultSet.getInt("nombreheure");
            double tauxHoraires = resultSet.getDouble("tauxhoraire");
            double montantAvantage = resultSet.getDouble("montantavantage");
            int heureSup = resultSet.getInt("heuresup");
            double montantpret = resultSet.getDouble("montantpret");
            double primeRisque = resultSet.getDouble("primeRisque");
            double primeAnciennete = resultSet.getDouble("primeAnciennete");
            double salaire=0;
            salaire = (((nombreHeurs+heureSup)*tauxHoraires)+montantAvantage+primeRisque+primeAnciennete) -
                    montantpret;
            listeDesSalaires.add(salaire);
        }

        return listeDesSalaires;
    }

    public Map listeSalaire() throws SQLException, ClassNotFoundException {
        Map<Integer, Double> listeDesSalaires= new HashMap<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM InfoPaie");
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("employe");
            int nombreHeurs = resultSet.getInt("nombreheure");
            double tauxHoraires = resultSet.getDouble("tauxhoraire");
            double montantAvantage = resultSet.getDouble("montantavantage");
            int heureSup = resultSet.getInt("heuresup");
            double montantpret = resultSet.getDouble("montantpret");
            double primeRisque = resultSet.getDouble("primeRisque");
            double primeAnciennete = resultSet.getDouble("primeAnciennete");
            double salaire=0;
            salaire = (((nombreHeurs+heureSup)*tauxHoraires)+montantAvantage+primeRisque+primeAnciennete) -
                    montantpret;
            listeDesSalaires.put(id,salaire);
        }
        return listeDesSalaires;
    }


    @Override
    public Double moyenSalaire() throws SQLException, ClassNotFoundException {

        double salaireMoyen = 0;
        List<Double> listeDesSalaires = listeSalaires();
        for(int salaires=0;salaires<listeDesSalaires.size();salaires++){
            salaireMoyen = salaireMoyen + listeDesSalaires.get(salaires);
        }
        salaireMoyen= salaireMoyen/listeDesSalaires.size();
        return salaireMoyen;
    }

    @Override
    public int nombreEmployer() throws SQLException, ClassNotFoundException {

        int nbEmploye = 0;
        preparedStatement = DbConnexion.getPreparedStatement("SELECT COUNT(*) AS NB_EMPLOYES FROM EmployerChine");
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            nbEmploye = resultSet.getInt("NB_EMPLOYES");
        }

        return nbEmploye;
    }

    @Override
    public Double salaireMax() throws SQLException, ClassNotFoundException {

        List<Double> listeDesSalaires = listeSalaires();
        double salaireMax=listeDesSalaires.get(0);
        for(int salaire=1;salaire<listeDesSalaires.size();salaire++){
            if(salaireMax < listeDesSalaires.get(salaire)){
                salaireMax=listeDesSalaires.get(salaire);
            }
        }
        return salaireMax;
    }

    @Override
    public Double totalSalire() throws SQLException, ClassNotFoundException {
        double salaireTotal = 0;
        List<Double> listeDesSalaires = listeSalaires();
        for(int salaires=0;salaires<listeDesSalaires.size();salaires++){
            salaireTotal = salaireTotal + listeDesSalaires.get(salaires);
        }
        return salaireTotal;
    }

    @Override
    public EmployeChine minSalireEmploye() throws SQLException, ClassNotFoundException {
        Map<Integer,Double> listedesSaires = listeSalaire();
        double salairemin = listedesSaires.get(1);
        int indice = 0;
        EmployeChine employe = new EmployeChine();
        for(int id : listedesSaires.keySet()){
            if(salairemin>listedesSaires.get(id)){
                salairemin=listedesSaires.get(id);
                indice=id;
            }
        }
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM EmployerChine where id=?");
        preparedStatement.setInt(1, indice);
        resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            int age = resultSet.getInt("age");
            String sexe = resultSet.getString("sexe");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String adresse = resultSet.getString("adresse");
            employe.setId(id);
            employe.setNom(nom);
            employe.setPrenom(prenom);
            employe.setAge(age);
            employe.setSexe(sexe);
            employe.setTelephone(telephone);
            employe.setEmail(email);
            employe.setAdresse(adresse);
        }
        return employe;
    }

    @Override
    public EmployeChine maxSalireEmploye() throws SQLException, ClassNotFoundException {
        Map<Integer,Double> listedesSaires = listeSalaire();
        double salairemax = 0;
        int indice = 0;
        EmployeChine employe = new EmployeChine();
        for(int id : listedesSaires.keySet()){
            if(salairemax<listedesSaires.get(id)){
                salairemax=listedesSaires.get(id);
                indice=id;
            }
        }
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM EmployerChine where id=?");
        preparedStatement.setInt(1, indice);
        resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            int age = resultSet.getInt("age");
            String sexe = resultSet.getString("sexe");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String adresse = resultSet.getString("adresse");
            employe.setId(id);
            employe.setNom(nom);
            employe.setPrenom(prenom);
            employe.setAge(age);
            employe.setSexe(sexe);
            employe.setTelephone(telephone);
            employe.setEmail(email);
            employe.setAdresse(adresse);
        }
        return employe;
    }

    @Override
    public List<EmployeChine> listeEmployes() throws SQLException, ClassNotFoundException {
        List<EmployeChine>listeDesEmployes = new ArrayList();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM EmployerChine");
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            int age = resultSet.getInt("age");
            String sexe = resultSet.getString("sexe");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String adresse = resultSet.getString("adresse");
            EmployeChine employe = new EmployeChine();
            employe.setId(id);
            employe.setNom(nom);
            employe.setPrenom(prenom);
            employe.setAge(age);
            employe.setSexe(sexe);
            employe.setTelephone(telephone);
            employe.setEmail(email);
            employe.setAdresse(adresse);
            listeDesEmployes.add(employe);
        }
        return listeDesEmployes;
    }
}
