package camillyLarissaCostaSilva.estoque;

import java.util.ArrayList;

public class Produto {
	private int cod;
	private String desc;
	private int min;
	private double lucro; 
	
	private int quantidade = 0;
	private double precoDeVenda = 0;
	private double precoDeCompra = 0;
	private String extrato = "";
	private ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	
	public Produto(int cod, String desc, int min, double lucro) {
		this.cod = cod;
		this.desc = desc;
		this.min = min;
		this.lucro = lucro;
	}
	public void setFornecedor(Fornecedor f) {
		fornecedores.add(f);
	}
	
	public ArrayList<Fornecedor> getFornecedor() {
		return this.fornecedores;
	}
	
	public void compra(int quant, double val) {
		precoDeCompra = (quantidade * precoDeCompra + quant * val)/(quantidade+quant);
		precoDeVenda = precoDeCompra * (1 + lucro);
		incrementarQuantidade(quant);
		extrato = extrato + "Compra - " + " Quantidade Comprada: " + quant + " Valor: " + val + " Quantidade Atual: " + quantidade + "\n";
	}
		
	public double venda(int quant) {
		decrementarQuantidade(quant);
		extrato = extrato + "Venda - " + "Quantidade Vendida: " + quant + " Valor vendido: " + precoDeVenda * quant + " Quantidade Atual: " + quantidade + "\n";
		return precoDeVenda * quant;
	}
	
	public double precoDeCompra() {
		return precoDeCompra;
	}
	
	public double precoDeVenda() {
		return precoDeVenda;
	}
	
	public int quantidade() {
		return quantidade;
	}
	public void incrementarQuantidade(int quant) {
		quantidade = quantidade + quant;
	}
	public void decrementarQuantidade(int quant) {
		quantidade = quantidade - quant;
	}
	public String extrato() {
		return extrato;
	}

	public int getCod() {
		return cod;
	}
	public String getDesc() {
		return desc;
	}
	public int getMin() {
		return min;
	}
	public String toString() {
		return "codigo = " + cod + ", descrição = " + desc + ", estoque minimo = " + min + ", luco = " + lucro ;
	}
}
