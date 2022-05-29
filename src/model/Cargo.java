package model;

public class Cargo {
    private int idCargo;
    private String cargo;

    public Cargo(int idCargo, String cargo) {
        this.idCargo = idCargo;
        this.cargo = cargo;
    }

    public Cargo() {
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void mostrarDados(){
        System.out.println("-----Cargo-----\n" +
                "Nome: " + this.getCargo() + "\n" +
                "Número do cargo: " + this.getIdCargo() + "\n");
    }
}
