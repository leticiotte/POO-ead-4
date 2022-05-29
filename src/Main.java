import data.CandidatoSQLiteDAO;
import data.CargoSQLiteDAO;
import data.PartidoSQLiteDAO;
import model.Candidato;
import model.Cargo;
import model.Partido;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CargoSQLiteDAO cargoDAO = new CargoSQLiteDAO();
        PartidoSQLiteDAO partidoDAO = new PartidoSQLiteDAO();
        CandidatoSQLiteDAO candidatoDAO = new CandidatoSQLiteDAO();

//        Cargo cargo1 = new Cargo(1,"Presidente");
//        Cargo cargo2 = new Cargo(2,"Vereador");
//        cargoDAO.salvar(cargo1);
//        cargoDAO.salvar(cargo2);
//
//        Partido partido1 = new Partido(13, "Partido dos Trabalhadores", "PT");
//        Partido partido2 = new Partido(50, "Partido Socialismo e Liberdade", "PSOL");
//        partidoDAO.salvar(partido1);
//        partidoDAO.salvar(partido2);
////
//        Candidato candidato1 = new Candidato(13,"Lula", cargo1, partido1);
//        Candidato candidato2 = new Candidato(50501,"Djalma Nery", cargo2, partido2);
//        candidatoDAO.salvar(candidato1);
//        candidatoDAO.salvar(candidato2);
//
//        candidatoDAO.apagar(50501);

        List<Cargo> listaCargos = cargoDAO.buscarTodos();
        for (Cargo c : listaCargos )
            c.mostrarDados();

        List<Partido> listaPartidos = partidoDAO.buscarTodos();
        for (Partido p : listaPartidos )
            p.mostrarDados();

        List<Candidato> listaCandidato = candidatoDAO.buscarTodos();
        for (Candidato c : listaCandidato )
            c.mostrarDados();
    }
}
