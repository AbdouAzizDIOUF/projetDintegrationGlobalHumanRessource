package france.dao;

import france.model.EmployerFrance;
import france.model.InfoPaieFrance;
import france.model.InfoProfessionelFrance;
import france.model.SalaireFrance;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import dao.IDaoFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IDaoFunctionImplFrance implements IDaoFunction<EmployerFrance, InfoProfessionelFrance, InfoPaieFrance, SalaireFrance> {

    private static final String PATH = "E:\\Projets\\java\\classe\\projetIntegrationWithMaven\\src\\main\\resources\\datasources\\france\\";


    @Override
    public double moyenSalaireMounth(String date) throws IOException {
        return (this.getSalairesByMounth(date).stream().mapToDouble(SalaireFrance::getSalaire).sum() / this.getSalairesByMounth(date).size());
    }

    @Override
    public int getNombreEmployer() throws IOException {
        return getEmployees().size();
    }

    @Override
    public double getBudgetTotal(String date) throws IOException {
        return Math.round(this.getSalairesByMounth(date).stream().mapToDouble(SalaireFrance::getSalaire).sum());
    }

    @Override
    public double pourcentageFeminin() throws IOException {
        int nbFemmes = (int) getEmployees().stream().filter(emp -> "feminin".equals(emp.getSexe())).count();
        return Math.round(((double) (nbFemmes*100)/this.getEmployees().size()));
    }

    @Override
    public double pourcentageHomme() throws IOException {
        int nbHommes = (int) getEmployees().stream().filter(emp -> "masculin".equals(emp.getSexe())).count();
        return  Math.round(((double)(nbHommes*100)/getEmployees().size()));
    }

    @Override
    public double pourcentageCadres() throws IOException {
        int cadre = (int) this.getInfoProffs().stream().filter(p -> "Cadre".equals(p.getStatut())).count();
        return Math.round((double)((cadre * 100) / this.getInfoProffs().size()));
    }

    @Override
    public double pourcentageOuvriers() throws IOException {
        return Math.round((100-this.pourcentageCadres()));
    }


    @Override
    public SalaireFrance minSalaireEmployeByMounth(String date) throws IOException {
        return this.getSalairesByMounth(date).get(0);
    }

    @Override
    public SalaireFrance maxSalaireEmployeByMounth(String date) throws IOException {
        return this.getSalairesByMounth(date).get(getSalairesByMounth(date).size()-1);
    }

    @Override
    public List<SalaireFrance> getSalairesByMounth(String date) throws IOException {
        List<SalaireFrance> salaires = new ArrayList<>();
        getEmployees().forEach(empl->{
            try {
                getInfoProffs().forEach(prof->{
                    try {
                        getInfoPaiesByMounth(date).forEach(paie->{
                            if( (empl.getId()==prof.getEmployeId()) && (prof.getEmployeId() == paie.getEmployeId()))
                            {
                                SalaireFrance salaire = new SalaireFrance();
                                salaire.setMatricule(prof.getNumMatricule());
                                salaire.setNom(empl.getNom());
                                salaire.setPrenom(empl.getPrenom());
                                salaire.setNombreHeure(paie.getNombreHeure());
                                salaire.setHeureSup(paie.getHeureSup());
                                salaire.setAvantage(paie.getMontantAvantage());
                                salaire.setIndTransport(paie.getIndTransport());
                                salaire.setPret(paie.getMontantPret());
                                salaire.setIndMatrimoniale(paie.getIndMatrimoniale());
                                salaire.setPays(prof.getPays());
                                salaire.setSalaire(getSalaire(paie));
                                salaire.setPeriodePaie(paie.getPeriodePaie());

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
        Collections.sort(salaires);

        return salaires;
    }

    @Override
    public List<EmployerFrance> getEmployees() throws IOException {
        File employerFile = new File(PATH + "employeFrance.xlsx");
        FileInputStream fis = new FileInputStream(employerFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIter = sheet.rowIterator();
        List<EmployerFrance> listeEmpl = new ArrayList<>();
        int rows = 0;
        while (rowIter.hasNext())
        {
            Row row = rowIter.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            EmployerFrance empl = new EmployerFrance();
            if (rows!=0)
            {
                int i=0;
                while (cellIterator.hasNext())
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
        }
        Collections.sort(listeEmpl);
        workbook.close();
        fis.close();

        return listeEmpl;
    }

    @Override
    public List<InfoProfessionelFrance> getInfoProffs() throws IOException {
        File infoProff = new File(PATH+"infoProffFrance.xlsx");
        FileInputStream fis = new FileInputStream(infoProff);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIter = sheet.rowIterator();
        List<InfoProfessionelFrance> infoProffList = new ArrayList<>();
        int rows = 0;
        while (rowIter.hasNext())
        {
            Row row = rowIter.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            InfoProfessionelFrance infPro = new InfoProfessionelFrance();
            if (rows!=0)
            {
                int i=0;
                while (cellIterator.hasNext())
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
                    }else if(i==10){
                        infPro.setMatrimoniale(cell.toString());
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
        }
        workbook.close();
        fis.close();

        return infoProffList;
    }

    @Override
    public List<InfoPaieFrance> getInfoPaiesByMounth(String date) throws IOException{
        List<InfoPaieFrance> infoPaieList = new ArrayList<>();
        this.getInfoPaies().forEach(paie->{
            if (paie.getPeriodePaie().equals(date)){
                infoPaieList.add(paie);
            }});

        return infoPaieList;
    }

    private List<InfoPaieFrance> getInfoPaies() throws IOException {
        File infoPaiement = new File(PATH+"infoPaieFrance.xlsx");
        FileInputStream fis = new FileInputStream(infoPaiement);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIter = sheet.rowIterator();
        List<InfoPaieFrance> infoPaieList = new ArrayList<>();
        int rows = 0;
        while (rowIter.hasNext())
        {
            Row row = rowIter.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            InfoPaieFrance infPaie = new InfoPaieFrance();
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
                        infPaie.setIndMatrimoniale(Double.parseDouble(cell.toString()));
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

    private Double getSalaire(InfoPaieFrance paie){
        return ((paie.getNombreHeure() + paie.getHeureSup()) * paie.getTauxHoraire()) + paie.getMontantAvantage() + paie.getIndMatrimoniale() + paie.getIndTransport() - paie.getMontantPret();
    }

    private static int getIntValue(String val){
        String value = val.substring(0, val.lastIndexOf("."));
        return Integer.parseInt(value);
    }
}
