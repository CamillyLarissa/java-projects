package camillyLarissaCostaSilva.locadora;


public class Caminhao extends Veiculo{

    private double capacidadeCarga;

    public Caminhao(String marca, String modelo, int anoFabricacao, double valorAvaliado, double valorDiaria,String placa, double capacidadeCarga) {
        super(marca, modelo, anoFabricacao, valorAvaliado, valorDiaria, placa);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getValorAluguel(int dias) {
        return (this.valorDiaria + this.seguro()) * dias;
    }
    
    public double seguro() {
    	return ((this.valorAvaliado * 0.08)/365);
    }

    public void aumentarDiaria(double aumento){
        this.valorDiaria = this.valorDiaria *(1 + aumento);
    }

    public void reduzirDiaria(double reducao){
    	this.valorDiaria = this.valorDiaria *(1 - reducao);
    }
    
    public void aumentarValorAvaliado(double valor){
        this.valorAvaliado = valorAvaliado * (1 + valor);
    }

    public void reduzirValorAvaliado(double valor){
        this.valorAvaliado = valorAvaliado * (1 - valor);
    }
    public double getCapacidadeCarga() {
        return this.capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    
}
