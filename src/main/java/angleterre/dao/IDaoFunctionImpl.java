package angleterre.dao;

import angleterre.model.EmployeAngleterre;
import chine.model.EmployeChine;
import lombok.NoArgsConstructor;
import model.Employe;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@NoArgsConstructor
public class IDaoFunctionImpl implements IDaoFunction {

    @Override
    public Double moyenSalaire() {


        return null;
    }

    @Override
    public int nombreEmployer() {
        return 0;
    }

    @Override
    public Double salaireMax() {
        return null;
    }

    @Override
    public Double totalSalire() {
        return null;
    }

    @Override
    public EmployeChine minSalireEmploye() {
        return null;
    }

    @Override
    public EmployeChine maxSalireEmploye() {


        return null;
    }

    @Override
    public List<EmployeAngleterre> listeEmployes() throws IOException
    {
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
            System.out.println();
        }

        Collections.sort(listeEmpl);
       /* listeEmpl.forEach(employeAngleterre -> {
            System.out.println(employeAngleterre.toString());
        });*/
        workbook.close();
        fis.close();

        return listeEmpl;
    }

    private static int getIntValue(String val){
        String value = val.substring(0, val.lastIndexOf("."));
        return Integer.parseInt(value);
    }
}
