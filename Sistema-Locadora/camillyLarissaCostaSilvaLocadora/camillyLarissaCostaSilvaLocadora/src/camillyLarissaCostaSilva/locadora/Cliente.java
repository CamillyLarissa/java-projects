package camillyLarissaCostaSilva.locadora;

public class Cliente {
    private int cpf;
    private String nome;

    public Cliente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

	public int getCpf() {
	    return this.cpf;
	 }
	
	 public void setCpf(int cpf) {
	    this.cpf = cpf;
	 }
	
	public String getNome() {
	    return this.nome;
	 }
	
	 public void setNome(String nome) {
	    this.nome = nome;
	 }
	 
}