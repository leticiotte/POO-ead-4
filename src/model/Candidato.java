package model;

public class Candidato {
    private int numero;
    private String nome;
    private Cargo cargo;
    private Partido partido;

    public Candidato(int numero, String nome, Cargo cargo, Partido partido) {
        this.numero = numero;
        this.nome = nome;
        this.cargo = cargo;
        this.partido = partido;
    }

    public Candidato() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void mostrarDados(){
        System.out.println("-----Candidato-----\n" +
                "Nome: " + this.getNome() + "\n" +
                "Número: " + this.getNumero() + "\n" +
                "Partido: " + this.getPartido().getNome() + "\n" +
                "Cargo: " + this.getCargo().getCargo() +  "\n");
    }
}
