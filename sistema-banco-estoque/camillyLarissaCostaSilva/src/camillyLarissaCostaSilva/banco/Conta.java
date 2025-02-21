package camillyLarissaCostaSilva.banco;

public class Conta {
	private int numero;
	private double saldo;
	private String extrato = "";
    private Pessoa dono;
	
	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}

	public Conta(int n) {
		numero = n;
	}
	
	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getExtrato() {
		return extrato;
	}
	
	public String toString() {
		return "Conta: " + "numero = " + numero  + "    Pessoa = "+ dono;
	}

	public void credito(double valor) {
		saldo = saldo + valor;
		extrato = extrato + "Crédito: " + valor + " Saldo: " + saldo + "\n";
	}
	
	public boolean debito(double valor) {
		if (valor <= saldo) {
		  saldo = saldo - valor;
		  extrato = extrato + "Débito: " + valor + " Saldo: " + saldo + "\n";
		  return true;
		}
		return false;
	}

}
