package chine.dao;

import chine.model.EmployerChine;
import chine.model.InfoPaieChine;
import chine.model.InfoProfessionelChine;
import chine.model.SalaireChine;
import dao.IDaoFunction;
import chine.database.DbConnexion;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class IDaoFunctionImplChine implements IDaoFunction<EmployerChine, InfoProfessionelChine, InfoPaieChine, SalaireChine> {

    public ResultSet resultSet = null;
    private PreparedStatement preparedStatement;

    @Override
    public List<EmployerChine> getEmployees() throws IOException, SQLException, ClassNotFoundException {
        List<EmployerChine> employerChineList = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM EmployerChine");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            EmployerChine employe = new EmployerChine();
            employe.setId(resultSet.getInt("id"));
            employe.setNom(resultSet.getString("nom"));
            employe.setPrenom(resultSet.getString("prenom"));
            employe.setAge(resultSet.getInt("age"));
            employe.setSexe(resultSet.getString("sexe"));
            employe.setTelephone(resultSet.getString("telephone"));
            employe.setEmail(resultSet.getString("email"));
            employe.setAdresse(resultSet.getString("adresse"));

            employerChineList.add(employe);
        }

        return employerChineList;
    }

    @Override
    public List<InfoProfessionelChine> getInfoProffs() throws IOException, SQLException, ClassNotFoundException {
        List<InfoProfessionelChine> infoProfessionelChineList = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM infoprofessionnelleChine");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            InfoProfessionelChine info = new InfoProfessionelChine();
            info.setNumMatricule(resultSet.getString("numMatricule"));
            info.setEmployeId(resultSet.getInt("employeId"));
            info.setStatut(resultSet.getString("statut"));
            info.setPoste(resultSet.getString("poste"));
            info.setVille(resultSet.getString("ville"));
            info.setContrat(resultSet.getString("contrat"));
            info.setDateDebutContrat(resultSet.getString("dateDebutContrat"));
            info.setDateFinContrat(resultSet.getString("dateFinContrat"));
            info.setDepartement(resultSet.getString("departement"));
            info.setSalaireDeBase(resultSet.getDouble("salairedebase"));
            info.setPays(resultSet.getString("pays"));

            infoProfessionelChineList.add(info);
        }

        return infoProfessionelChineList;
    }

    @Override
    public int getNombreEmployer() throws IOException, SQLException, ClassNotFoundException {
        return this.getEmployees().size();
    }

    @Override
    public List<InfoPaieChine> getInfoPaiesByMounth(String date) throws SQLException, ClassNotFoundException {
        List<InfoPaieChine> infoPaies = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM infopaiesenegal WHERE periodepaie="+date);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            InfoPaieChine paie = new InfoPaieChine();
            paie.setId(resultSet.getInt("id"));
            paie.setEmployeId(resultSet.getInt("employeid"));
            paie.setNombreHeure(resultSet.getDouble("nombreheure"));
            paie.setTauxHoraire(resultSet.getDouble("tauxhoraire"));
            paie.setMontantAvantage(resultSet.getDouble("montantavantage"));
            paie.setHeureSup(resultSet.getInt("heuresup"));
            paie.setMontantPret(resultSet.getDouble("montantpret"));
            paie.setPrimeRisque(resultSet.getDouble("primeRisque"));
            paie.setPrimeAnciennete(resultSet.getDouble("primeAnciennete"));
            paie.setPeriodePaie(resultSet.getString("periodepaie"));

            infoPaies.add(paie);
        }
        return infoPaies;
    }

    @Override
    public List<SalaireChine> getSalairesByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        List<SalaireChine> salaires = new ArrayList<>();
        getEmployees().forEach(empl->{
            try {
                getInfoProffs().forEach(prof->
                {
                    try {
                        getInfoPaiesByMounth(date).forEach(paie->{
                            if( (empl.getId()==prof.getEmployeId()) && (prof.getEmployeId() == paie.getEmployeId()))
                            {
                                SalaireChine salaire = new SalaireChine();
                                salaire.setMatricule(prof.getNumMatricule());
                                salaire.setNom(empl.getNom());
                                salaire.setPrenom(empl.getPrenom());
                                salaire.setNombreHeure(paie.getNombreHeure());
                                salaire.setHeureSup(paie.getHeureSup());
                                salaire.setAvantage(paie.getMontantAvantage());
                                salaire.setPrimeRisque(paie.getPrimeRisque());
                                salaire.setPrimeAncienete(paie.getPrimeAnciennete());
                                salaire.setPret(paie.getMontantPret());
                                salaire.setPays(prof.getPays());
                                salaire.setSalaire(getSalaire(paie));
                                salaire.setPeriodePaie(paie.getPeriodePaie());

                                salaires.add(salaire);
                            }
                        });
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        Collections.sort(salaires);

        return salaires;
    }

    @Override
    public SalaireChine minSalaireEmployeByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return this.getSalairesByMounth(date).get(0);
    }

    @Override
    public SalaireChine maxSalaireEmployeByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return this.getSalairesByMounth(date).get(getSalairesByMounth(date).size()-1);
    }

    @Override
    public double moyenSalaireMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return (this.getSalairesByMounth(date).stream().mapToDouble(SalaireChine::getSalaire).sum() / this.getSalairesByMounth(date).size());
    }

    @Override
    public double getBudgetTotal(String date) throws SQLException, IOException, ClassNotFoundException {
        return Math.round(this.getSalairesByMounth(date).stream().mapToDouble(SalaireChine::getSalaire).sum());
    }

    @Override
    public double pourcentageHomme() throws SQLException, IOException, ClassNotFoundException {
        return Math.round(100-this.pourcentageFeminin());
    }

    @Override
    public double pourcentageFeminin() throws SQLException, IOException, ClassNotFoundException {
        int nbFemmes = (int) getEmployees().stream().filter(emp -> "feminin".equals(emp.getSexe())).count();
        return Math.round(((double) (nbFemmes*100)/this.getEmployees().size()));
    }

    @Override
    public double pourcentageOuvriers() throws SQLException, IOException, ClassNotFoundException {
        return Math.round((100-this.pourcentageCadres()));
    }

    @Override
    public double pourcentageCadres() throws SQLException, IOException, ClassNotFoundException {
        int cadre = (int) this.getInfoProffs().stream().filter(p -> "Cadre".equals(p.getStatut())).count();
        return Math.round((double)((cadre * 100) / this.getInfoProffs().size()));
    }

    private Double getSalaire(InfoPaieChine paie){
        return ((paie.getNombreHeure() + paie.getHeureSup()) * paie.getTauxHoraire()) + paie.getMontantAvantage() + paie.getPrimeAnciennete() + paie.getPrimeRisque() - paie.getMontantPret();
    }
}
