package camillyLarissaCostaSilva.locadora;

import java.util.Date;

public class Movimentacao {
	
	private Date data;
    private Veiculo veiculo;
    private double valor;
    private int dias;

    public Movimentacao(Veiculo veiculo, Date data, double valor, int dias){
        this.data = data;
        this.veiculo = veiculo;
        this.valor = valor;
        this.dias = dias;
    }
    public String toString(){
        return "Data: " + this.data + " Veiculo: " + this.veiculo + " Valor: " + this.valor + " Dias: " + this.dias;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }
    
    public Date getData() {
		return this.data;
	}
    
    public double getValor() {
    	return this.valor;
    }
    
    public int getDias() {
    	return this.dias;
    }

}

