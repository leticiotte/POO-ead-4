package data;

import model.Candidato;
import model.Cargo;
import model.Partido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoSQLiteDAO implements CandidatoDAO{
    @Override
    public void salvar(Candidato candidato) {
        String sql = "INSERT INTO candidato values (?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,candidato.getNumero());
            stmt.setString(2,candidato.getNome());
            stmt.setInt(3,candidato.getPartido().getNumero());
            stmt.setInt(4,candidato.getCargo().getIdCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Candidato candidato) {
        String sql = "UPDATE candidato SET nome=?, partido=?, cargo=? WHERE numero=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,candidato.getNome());
            stmt.setInt(2,candidato.getPartido().getNumero());
            stmt.setInt(3,candidato.getCargo().getIdCargo());
            stmt.setInt(4,candidato.getNumero());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(int numero) {
        String sql = "DELETE FROM candidato WHERE numero=?";

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,numero);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Candidato buscar(int numero) {
        String sql = "SELECT * FROM candidato WHERE numero=?";
        Candidato candidato = null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,numero);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido partido = new PartidoSQLiteDAO().buscar(rs.getInt("partido"));
                Cargo cargo = new CargoSQLiteDAO().buscar(rs.getInt("cargo"));
                candidato = new Candidato(rs.getInt("numero"),
                        rs.getString("nome"),
                        cargo,
                        partido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidato;
    }

    @Override
    public List<Candidato> buscarTodos() {
        String sql = "SELECT * FROM candidato";
        List<Candidato> listaCandidatos = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido partido = new PartidoSQLiteDAO().buscar(rs.getInt("partido"));
                Cargo cargo = new CargoSQLiteDAO().buscar(rs.getInt("cargo"));
                Candidato candidato = new Candidato(rs.getInt("numero"),
                        rs.getString("nome"),
                        cargo,
                        partido);
                listaCandidatos.add(candidato);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCandidatos;
    }
}
