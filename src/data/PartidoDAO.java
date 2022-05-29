package data;

import model.Partido;
import java.util.List;

public interface PartidoDAO {
    void  salvar(Partido partido);
    void atualizar (Partido partido);
    void apagar (int numero);
    Partido buscar (int numero);
    List<Partido> buscarTodos();
}
