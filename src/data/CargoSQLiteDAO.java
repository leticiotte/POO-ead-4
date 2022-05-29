package data;

import model.Cargo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoSQLiteDAO implements CargoDAO{
    @Override
    public void salvar(Cargo cargo) {
        String sql = "INSERT INTO cargo values (?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,cargo.getIdCargo());
            stmt.setString(2,cargo.getCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Cargo cargo) {
        String sql = "UPDATE cargo SET cargo=? WHERE idCargo=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,cargo.getCargo());
            stmt.setInt(2,cargo.getIdCargo());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(int idCargo) {
        String sql = "DELETE FROM cargo WHERE idCargo=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idCargo);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cargo buscar(int idCargo) {
        String sql = "SELECT * FROM cargo WHERE idCargo=?";
        Cargo cargo = null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idCargo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cargo = new Cargo(rs.getInt("idCargo"),
                        rs.getString("cargo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargo;
    }

    @Override
    public List<Cargo> buscarTodos() {
        String sql = "SELECT * FROM cargo";
        List<Cargo> listaCargos = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cargo cargo = new Cargo(rs.getInt("idCargo"),
                        rs.getString("cargo"));
                listaCargos.add(cargo);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCargos;
    }
}
