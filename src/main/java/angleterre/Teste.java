package angleterre;

import angleterre.dao.IDaoFunctionImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.*;


public class Teste {

    public static void main(String[] args) throws IOException, InvalidFormatException {

       IDaoFunctionImpl iDaoFunction = new IDaoFunctionImpl();

        //System.out.println(iDaoFunction.maxSalaireEmploye());
        //System.out.println(iDaoFunction.minSalaireEmploye());
        System.out.println(iDaoFunction.moyenSalaire());
        /*iDaoFunction.listeSalaires().forEach(salaire->{
            System.out.println(salaire.toString());
        });*/
    }


    private static int getIntValue(String val){
        String value = val.substring(0, val.lastIndexOf("."));

        return Integer.parseInt(value);
    }
}
