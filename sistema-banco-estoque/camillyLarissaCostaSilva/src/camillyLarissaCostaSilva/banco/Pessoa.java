package camillyLarissaCostaSilva.banco;

public class Pessoa {
	private int cpf;
	private String nome;
	private Conta conta;
	private String senha;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa(int n, String str) {
		cpf = n;
		nome = str;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public int getCpf() {
		return cpf;
	}
	public String toString() {
		return "nome = " + nome + "  cpf = "+ cpf;
	}
}
