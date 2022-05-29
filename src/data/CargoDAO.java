package data;

import model.Cargo;
import java.util.List;

public interface CargoDAO {
    void  salvar(Cargo cargo);
    void atualizar (Cargo cargo);
    void apagar (int idCargo);
    Cargo buscar (int idCargo);
    List<Cargo> buscarTodos();
}
