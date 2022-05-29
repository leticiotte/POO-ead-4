package data;

import model.Candidato;
import java.util.List;

public interface CandidatoDAO {
    void  salvar(Candidato candidato);
    void atualizar (Candidato candidato);
    void apagar (int numero);
    Candidato buscar (int numero);
    List<Candidato> buscarTodos();
}
