package camillyLarissaCostaSilva.locadora;

import java.util.Date;

public class Aluguel {
    
    private Veiculo veiculo;
    private Date data;
    private int dias;
    private Cliente cliente;
    private double valor;
    private boolean alugado;

    public Aluguel(Veiculo veiculo, Date data, int dias, Cliente cliente, double valor, boolean alugado) {
        this.veiculo = veiculo;
        this.data = data;
        this.dias = dias;
        this.cliente = cliente;
        this.valor = valor;
        this.alugado = alugado;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    // pegando data
    public Date getData() {
        return this.data;
    }
    //definindo data
    public void setData(Date data) {
        this.data = data;
    }
    
    public int getDias() {
        return this.dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isAlugado() {
        return this.alugado;
    }

    public boolean getAlugado() {
        return this.alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
    
   
}