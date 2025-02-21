package camillyLarissaCostaSilva.locadora;


public abstract class Veiculo {

    protected String marca;
    protected String modelo;
    protected int anoFabricacao;
    protected double valorAvaliado;
    protected double valorDiaria;
    protected String placa;

    public Veiculo(String marca, String modelo, int anoFabricacao, double valorAvaliado, double valorDiaria,String placa) {
        
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valorAvaliado = valorAvaliado;
        this.valorDiaria = valorDiaria;
        this.placa = placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoDeFabricacao() {
        return this.anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getValorAvaliado() {
        return this.valorAvaliado;
    }

    public void setValorAvaliado(double valorAvaliado) {
        this.valorAvaliado = valorAvaliado;
    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

   

    public abstract double getValorAluguel(int dias); 

    public abstract void aumentarDiaria(double aumento);
       
    public abstract void reduzirDiaria(double reducao);
    
    public abstract void aumentarValorAvaliado(double valor);

    public abstract void reduzirValorAvaliado(double valor);

}

