package angleterre;

import angleterre.dao.IDaoFunctionImplAngletterre;

import java.io.IOException;

public class Teste {

    public static void main(String[] args) throws IOException {
        IDaoFunctionImplAngletterre idao = new IDaoFunctionImplAngletterre();
        //idao.listeSalairesByMounth("01/02/2021-28/02/2021").forEach(s-> System.out.println(s.toString()));
        //System.out.println(idao.maxSalaireEmployeByMounth("01/02/2021-28/02/2021").toString());
        //System.out.println(idao.minSalaireEmployeByMounth("01/02/2021-28/02/2021").toString());
        //idao.listeSalaires().forEach(salaire-> System.out.println(salaire.toString()));
        //System.out.println(idao.pourcentageHomme()+" %");
        //System.out.println(idao.pourcentageFeminin()+" %");
        //System.out.println(idao.moyenSalaireMounth("01/02/2021-28/02/2021"));
        System.out.println(idao.pourcentageFeminin());
        System.out.println(idao.pourcentageHomme());
        //System.out.println(idao.pourcentageOuvriers());
        //idao.getInfoProffs().forEach(p-> System.out.println(p.toString()));
    }
}
