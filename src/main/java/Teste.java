import java.io.IOException;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Mediateur m = new Mediateur();

        m.getSalairesEmployes("Angleter", "01/02/2021-28/02/2021").forEach(e-> System.out.println(e.toString()));
    }
}
