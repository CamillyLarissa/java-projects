package camillyLarissaCostaSilva.estoque;

public class Fornecedor {
	private int cnpj;
	private String nome;
	
	public Fornecedor(int cnpj, String str) {
		this.cnpj = cnpj;
		this.nome = str;
	}
	
	public int getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "cnpj = " + cnpj + ", nome = " + nome ;
		
	}
}
