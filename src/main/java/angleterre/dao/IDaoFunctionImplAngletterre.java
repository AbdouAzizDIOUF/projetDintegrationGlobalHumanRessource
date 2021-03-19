package angleterre.dao;

import angleterre.model.EmployeAngleterre;
import angleterre.model.InfoPaieAngleterre;
import angleterre.model.InfoProfessionelAngleterre;
import angleterre.model.Salaire;
import chine.model.EmployeChine;
import lombok.NoArgsConstructor;
import model.Employe;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IDaoFunctionImpl implements IDaoFunction {

    private static final String PATH = "E:\\Projets\\java\\classe\\projetIntegrationWithMaven\\src\\main\\resources\\datasources\\angleterre\\";

    public static List<EmployeAngleterre> EMPLOYEES = null;
    public static List<InfoProfessionelAngleterre> INFO_PROF = null;
    public static List<InfoPaieAngleterre> INFO_PAIE = null;

    @Override
    public Double moyenSalaire() throws IOException {
        double salaireMoy = getInfoPaies().stream().mapToDouble(paie -> ( (paie.getNombreHeure() + paie.getHeureSup()) * paie.getTauxHoraire()) + paie.getMontantAvantage() + paie.getIndLogement() + paie.getIndTransport() - paie.getMontantPret()).sum();
        return (salaireMoy / getEmployees().size());
    }

    @Override
    public int nombreEmployer() throws IOException {
        return getEmployees().size();
    }

    @Override
    public Double salaireMax() throws IOException {
        return null;
    }

    @Override
    public Double totalSalaire() throws IOException {
        return getInfoPaies().stream().mapToDouble(paie -> ( (paie.getNombreHeure() + paie.getHeureSup()) * paie.getTauxHoraire()) + paie.getMontantAvantage() + paie.getIndLogement() + paie.getIndTransport() - paie.getMontantPret()).sum();
    }

    @Override
    public Salaire minSalaireEmploye() throws IOException {
        Collections.sort(listeSalaires());
        int dernier = listeSalaires().size();

        return listeSalaires().get(0);
    }

    @Override
    public Salaire maxSalaireEmploye() throws IOException {
        Collections.sort(listeSalaires());
        int dernier = listeSalaires().size();

        return listeSalaires().get(dernier-1);
    }

    @Override
    public List<EmployeAngleterre> listeEmployes() throws IOException
    {
        return getEmployees();
    }

    @Override
    public List<Salaire> listeSalaires() throws IOException {
        List<Salaire> salaires = new ArrayList<>();
        getEmployees().forEach(empl->{
            try {
                getInfoProffs().forEach(prof->{
                    try {
                        getInfoPaies().forEach(paie->{
                            if( (empl.getId()==prof.getEmployeId()) && (prof.getEmployeId() == paie.getEmployeId()))
                            {
                                Salaire salaire = new Salaire();
                                salaire.setMatricule(prof.getNumMatricule());
                                salaire.setNom(empl.getNom());
                                salaire.setPrenom(empl.getPrenom());
                                salaire.setNombreHeure(paie.getNombreHeure());
                                salaire.setHeureSup(paie.getHeureSup());
                                salaire.setAvantage(paie.getMontantAvantage());
                                salaire.setIndLogement(paie.getIndLogement());
                                salaire.setIndTransport(paie.getIndTransport());
                                salaire.setPret(paie.getMontantPret());
                                salaire.setSalaire(getSalaire(paie));

                                salaires.add(salaire);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return salaires;
    }


    public List<EmployeAngleterre> getEmployees() throws IOException {
        File employerFile = new File(PATH + "employeAngleterre.xlsx");
        FileInputStream fis = new FileInputStream(employerFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIter = sheet.rowIterator();
        List<EmployeAngleterre> listeEmpl = new ArrayList<>();
        int rows = 0;
        while (rowIter.hasNext())
        {
            Row row = rowIter.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            EmployeAngleterre empl = new EmployeAngleterre();
            if (rows!=0)
            {
                int i=0;
                while(cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    if (i==0){
                        empl.setId(getIntValue(cell.toString()));
                    }else if(i==1){
                        empl.setNom(cell.toString());
                    }else if(i==2){
                        empl.setPrenom(cell.toString());
                    }else if(i==3){
                        empl.setAge(getIntValue(cell.toString()));
                    }else if(i==4){
                        empl.setSexe(cell.toString());
                    }else if(i==5){
                        empl.setTelephone(cell.toString());
                    }else if(i==6){
                        empl.setEmail(cell.toString());
                    }else{
                        empl.setAdresse(cell.toString());
                    }
                    i++;
                }
            }
            if (rows!=0) {
                listeEmpl.add(empl);
            }
            ++rows;
            //System.out.println();
        }

        Collections.sort(listeEmpl);

        workbook.close();
        fis.close();

        return listeEmpl;
    }

    public List<InfoProfessionelAngleterre> getInfoProffs() throws IOException {
        File infoProff = new File(PATH+"infoProffAngleterre.xlsx");
        FileInputStream fis = new FileInputStream(infoProff);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIter = sheet.rowIterator();
        List<InfoProfessionelAngleterre> infoProffList = new ArrayList<>();
        int rows = 0;
        while (rowIter.hasNext())
        {
            Row row = rowIter.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            InfoProfessionelAngleterre infPro = new InfoProfessionelAngleterre();
            if (rows!=0)
            {
                int i=0;
                while(cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    if (i==0){
                        infPro.setNumMatricule(cell.toString());
                    }else if(i==1){
                        infPro.setEmployeId(getIntValue(cell.toString()));
                    }else if(i==2){
                        infPro.setStatut(cell.toString());
                    }else if(i==3){
                        infPro.setPoste(cell.toString());
                    }else if(i==4){
                        infPro.setVille(cell.toString());
                    }else if(i==5){
                        infPro.setContrat(cell.toString());
                    }else if(i==6){
                        infPro.setDateDebutContrat(cell.toString());
                    }else if(i==7){
                        infPro.setDateFinContrat(cell.toString());
                    }else if(i==8){
                        infPro.setDepartement(cell.toString());
                    }else if(i==9){
                        infPro.setSalaireDeBase(Double.parseDouble(cell.toString()));
                    }else{
                        infPro.setPays(cell.toString());
                    }
                    i++;
                }
            }
            if (rows!=0) {
                infoProffList.add(infPro);
            }
            ++rows;
            //System.out.println();
        }

        workbook.close();
        fis.close();

        return infoProffList;
    }


    public List<InfoPaieAngleterre> getInfoPaies() throws IOException {
        File infoPaiement = new File(PATH+"infoPaieAngleterre.xlsx");
        FileInputStream fis = new FileInputStream(infoPaiement);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIter = sheet.rowIterator();
        List<InfoPaieAngleterre> infoPaieList = new ArrayList<>();
        int rows = 0;
        while (rowIter.hasNext())
        {
            //System.out.println("fjiiiiiiiiiiiiiiiiiiiiii");
            Row row = rowIter.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            InfoPaieAngleterre infPaie = new InfoPaieAngleterre();
            if (rows!=0)
            {
                int i=0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (i==0){
                        infPaie.setId(getIntValue(cell.toString()));
                    }else if(i==1){
                        infPaie.setEmployeId(getIntValue(cell.toString()));
                    }else if (i==2){
                        infPaie.setNombreHeure(Double.parseDouble(cell.toString()));
                    }else if (i==3){
                        infPaie.setTauxHoraire(Double.parseDouble(cell.toString()));
                    }else if (i==4){
                        infPaie.setMontantAvantage(Double.parseDouble(cell.toString()));
                    }else if (i==5){
                        infPaie.setHeureSup(getIntValue(cell.toString()));
                    }else if (i==6){
                        infPaie.setMontantPret(Double.parseDouble(cell.toString()));
                    }else if (i==7){
                        infPaie.setIndLogement(Double.parseDouble(cell.toString()));
                    }else if (i==8){
                        infPaie.setIndTransport(Double.parseDouble(cell.toString()));
                    }else{
                        infPaie.setPeriodePaie(cell.toString());
                    }
                    i++;
                }
            }
            if (rows!=0) {
                infoPaieList.add(infPaie);
            }
            ++rows;
        }

        workbook.close();
        fis.close();

        return infoPaieList;
    }

    private Double getSalaire(InfoPaieAngleterre paie){
       return ((paie.getNombreHeure() + paie.getHeureSup()) * paie.getTauxHoraire()) + paie.getMontantAvantage() + paie.getIndLogement() + paie.getIndTransport() - paie.getMontantPret();
    }

    private static int getIntValue(String val){
        String value = val.substring(0, val.lastIndexOf("."));
        return Integer.parseInt(value);
    }
}
