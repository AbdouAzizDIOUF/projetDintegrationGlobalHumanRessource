package angleterre;

import angleterre.dao.IDaoFunctionImpl;
import angleterre.model.EmployeAngleterre;
import angleterre.model.InfoPaieAngleterre;
import angleterre.model.InfoProfessionelAngleterre;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Teste {

    private static String[] columns = {"ID", "Nom", "Prenom", "Age", "Sexe", "Telephone", "Email", "Adresse"};

    private static String[] columnInfoProff = {"Num Matricule","Employe ID", "Statut", "Poste", "Ville", "Contrat", "Date Debut Contrat", "Date Fin Contrat", "Departement", "SalaireAngleterre De Base", "Pays"};

    private static String[] columnInfoPaies = {
            "ID","Employe ID","Nombre Heure", "taux Horraire", "Avantage", "Heure Sup","Pret", "Indemnite Logement", "Indemnite Transport", "Periode Paie"
    };

    private static final String FILE_EMP = "employeAngleterre.xlsx";
    private static final String FILE_INF_PROF = "infoProffAngleterre.xlsx";
    private static final String FILE_INF_PAIE = "infoPaieAngleterre.xlsx";

    private static final String NAME_SOURCE_EMPLOYE = "Employe";
    private static final String NAME_SOURCE_INFO_PROF = "InfoProfessionel";
    private static final String NAME_SOURCE_INFO_PAIE = "InfoPaie";

    private static List<EmployeAngleterre> employesListe = new ArrayList<>();
    private static List<InfoProfessionelAngleterre> infoProfessionelList = new ArrayList<>();
    private static List<InfoPaieAngleterre> infoPaieList = new ArrayList<>();

    public static void main(String[] args) throws IOException, InvalidFormatException {

        /*createFileSource(columnInfoPaies, FILE_INF_PAIE,NAME_SOURCE_INFO_PAIE);
        createFileSource(columnInfoProff, FILE_INF_PROF,NAME_SOURCE_INFO_PROF);
        createFileSource(columns, FILE_EMP,NAME_SOURCE_EMPLOYE);*/

    }


    static void readExcelFile() throws IOException {
        File employerFile = new File("E:\\Projets\\java\\classe\\projetIntegrationWithMaven\\src\\main\\resources\\datasources\\angleterre\\employeAngleterre.xlsx");
        FileInputStream fis = new FileInputStream(employerFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIter = sheet.rowIterator();
        List<EmployeAngleterre> listeEmpl = new ArrayList<>();
        int rows = 0;
        while(rowIter.hasNext())
        {
            Row row = rowIter.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            EmployeAngleterre empl = new EmployeAngleterre();
            if (rows!=0){
                int i=0;
                while(cellIterator.hasNext()){
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
            System.out.println();
        }

        Collections.sort(listeEmpl);
        listeEmpl.forEach(employeAngleterre -> {
            System.out.println(employeAngleterre.toString());
        });
        workbook.close();

        fis.close();
    }

    static void createAndInitExcelFileEmploye() throws IOException {
        employesListe.add(new EmployeAngleterre(1,"Diop","Tidiani",55,"masculin","778563565","tdiop@gmail.com","dakar"));
        employesListe.add(new EmployeAngleterre(2,"Diop","alassane",30,"masculin","771004541","tal@gmail.com","dakar"));
        employesListe.add(new EmployeAngleterre(3,"Diouf","aziz",35,"masculin","771003265","ral@gmail.com","dakar"));
        employesListe.add(new EmployeAngleterre(4,"Ndiaye","MATAR",20,"masculin","771013265","ral@gmail.com","dakar"));
        employesListe.add(new EmployeAngleterre(6,"Diouf","aziz",35,"masculin","771003265","ral@gmail.com","dakar"));
        employesListe.add(new EmployeAngleterre(7,"Ndiaye","MATAR",20,"masculin","771013265","ral@gmail.com","dakar"));
        employesListe.add(new EmployeAngleterre(8,"Diouf","aziz",35,"masculin","771003265","ral@gmail.com","dakar"));
        employesListe.add(new EmployeAngleterre(9,"Ndiaye","MATAR",20,"masculin","771013265","ral@gmail.com","dakar"));


        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Employes");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with employesListe data
        int rowNum = 1;

        for (EmployeAngleterre empl : employesListe) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(empl.getId());
            row.createCell(1).setCellValue(empl.getNom());
            row.createCell(2).setCellValue(empl.getPrenom());
            row.createCell(3).setCellValue(empl.getAge());
            row.createCell(4).setCellValue(empl.getSexe());
            row.createCell(5).setCellValue(empl.getTelephone());
            row.createCell(6).setCellValue(empl.getEmail());
            row.createCell(7).setCellValue(empl.getAdresse());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("E:\\Projets\\java\\classe\\projetIntegrationWithMaven\\src\\main\\resources\\datasources\\angleterre\\employeAngleterre.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
    }

    static void initDataSource(List<Object> listes, String sheetName){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.getSheet(sheetName);
        int rowNum = 1;

    }

    static void createFileSource(String[] columns, String fileName, String feille) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet(feille);

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("E:\\Projets\\java\\classe\\projetIntegrationWithMaven\\src\\main\\resources\\datasources\\angleterre\\"+fileName);
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
    }


    private static int getIntValue(String val){
        String value = val.substring(0, val.lastIndexOf("."));

        return Integer.parseInt(value);
    }
}
