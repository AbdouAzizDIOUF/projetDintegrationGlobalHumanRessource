package senegal.dao;

import senegal.database.DbConnexion;
import senegal.modele.EmployerSenegal;
import senegal.modele.InfoPaieSenegal;
import senegal.modele.InfoProfessionelSenegal;
import senegal.modele.SalaireSenegal;
import dao.IDaoFunction;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class IDaoFunctionImplSenegal implements IDaoFunction<EmployerSenegal, InfoProfessionelSenegal, InfoPaieSenegal, SalaireSenegal>{

    public ResultSet resultSet = null;
    private PreparedStatement preparedStatement;


    @Override
    public List<EmployerSenegal> getEmployees() throws IOException, SQLException, ClassNotFoundException {
        List<EmployerSenegal> employerSenegalList = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM employersenegal");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            EmployerSenegal employe = new EmployerSenegal();
            employe.setId(resultSet.getInt("id"));
            employe.setNom(resultSet.getString("nom"));
            employe.setPrenom(resultSet.getString("prenom"));
            employe.setAge(resultSet.getInt("age"));
            employe.setSexe(resultSet.getString("sexe"));
            employe.setTelephone(resultSet.getString("telephone"));
            employe.setEmail(resultSet.getString("email"));
            employe.setAdresse(resultSet.getString("adresse"));

            employerSenegalList.add(employe);
        }
        return employerSenegalList;
    }

    @Override
    public List<InfoProfessionelSenegal> getInfoProffs() throws IOException, SQLException, ClassNotFoundException {
        List<InfoProfessionelSenegal> infoProfessionelSenegalList = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM infoprofessionnelle");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            InfoProfessionelSenegal info = new InfoProfessionelSenegal();
            info.setNumMatricule(resultSet.getString("numMatricule"));
            info.setEmployeId(resultSet.getInt("employeId"));
            info.setStatut(resultSet.getString("statut"));
            info.setPoste(resultSet.getString("poste"));
            info.setVille(resultSet.getString("ville"));
            info.setContrat(resultSet.getString("contrat"));
            info.setDateDebutContrat(resultSet.getString("datedebutcontrat"));
            info.setDateFinContrat(resultSet.getString("datefincontrat"));
            info.setDepartement(resultSet.getString("departement"));
            info.setSalaireDeBase(resultSet.getDouble("salairedebase"));
            info.setPays(resultSet.getString("pays"));

            infoProfessionelSenegalList.add(info);
        }

        return infoProfessionelSenegalList;
    }

    @Override
    public int getNombreEmployer() throws IOException, SQLException, ClassNotFoundException {
        return this.getEmployees().size();
    }

    @Override
    public List<InfoPaieSenegal> getInfoPaiesByMounth(String date) throws SQLException, ClassNotFoundException {
        List<InfoPaieSenegal> infoPaies = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM infopaiesenegal WHERE periodepaie="+date);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            InfoPaieSenegal paie = new InfoPaieSenegal();
            paie.setId(resultSet.getInt("id"));
            paie.setEmployeId(resultSet.getInt("employeid"));
            paie.setNombreHeure(resultSet.getDouble("nombreheure"));
            paie.setTauxHoraire(resultSet.getDouble("tauxhoraire"));
            paie.setMontantAvantage(resultSet.getDouble("montantavantage"));
            paie.setHeureSup(resultSet.getInt("heuresup"));
            paie.setMontantPret(resultSet.getDouble("montantpret"));
            paie.setPrimeAssiduite(resultSet.getDouble("primeassiduite"));
            paie.setPrimeRestauration(resultSet.getDouble("primerestauration"));
            paie.setImpotRevenu(resultSet.getDouble("impotrevenu"));
            paie.setPeriodePaie(resultSet.getString("periodepaie"));

            infoPaies.add(paie);
        }
        return infoPaies;
    }

    @Override
    public List<SalaireSenegal> getSalairesByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        List<SalaireSenegal> salaires = new ArrayList<>();
        getEmployees().forEach(empl->{
            try {
                getInfoProffs().forEach(prof->
                {
                    try {
                        getInfoPaiesByMounth(date).forEach(paie->{
                            if( (empl.getId()==prof.getEmployeId()) && (prof.getEmployeId() == paie.getEmployeId()))
                            {
                                SalaireSenegal salaire = new SalaireSenegal();
                                salaire.setMatricule(prof.getNumMatricule());
                                salaire.setNom(empl.getNom());
                                salaire.setPrenom(empl.getPrenom());
                                salaire.setNombreHeure(paie.getNombreHeure());
                                salaire.setHeureSup(paie.getHeureSup());
                                salaire.setAvantage(paie.getMontantAvantage());
                                salaire.setImpotRevenue(paie.getImpotRevenu());
                                salaire.setPrimeAssidute(paie.getPrimeAssiduite());
                                salaire.setPrimeRestauration(paie.getPrimeRestauration());
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
    public SalaireSenegal minSalaireEmployeByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return this.getSalairesByMounth(date).get(0);
    }

    @Override
    public SalaireSenegal maxSalaireEmployeByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return this.getSalairesByMounth(date).get(getSalairesByMounth(date).size()-1);
    }

    @Override
    public double moyenSalaireMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return (this.getSalairesByMounth(date).stream().mapToDouble(SalaireSenegal::getSalaire).sum() / this.getSalairesByMounth(date).size());
    }

    @Override
    public double getBudgetTotal(String date) throws SQLException, IOException, ClassNotFoundException {
        return Math.round(this.getSalairesByMounth(date).stream().mapToDouble(SalaireSenegal::getSalaire).sum());
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

    private Double getSalaire(InfoPaieSenegal paie){
        return ((paie.getNombreHeure() + paie.getHeureSup()) * paie.getTauxHoraire()) + paie.getMontantAvantage() + paie.getPrimeAssiduite() + paie.getPrimeRestauration() - (paie.getMontantPret()+paie.getImpotRevenu());
    }
}
