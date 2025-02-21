package camillyLarissaCostaSilva.locadora;

public class Carro extends Veiculo{
    
    private int tipo;

    public Carro(String marca, String modelo, int anoFabricacao, double valorAvaliado, double valorDiaria,String placa, int tipo) {
        super(marca, modelo, anoFabricacao, valorAvaliado, valorDiaria, placa);
        this.tipo= tipo;
    }

    public double getValorAluguel(int dias) {
        return (this.valorDiaria + this.seguro()) * dias;
    }
    public double seguro() {
    	return ((this.valorAvaliado * 0.03)/365);
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

    public void setTipo(int tipo) {
        this.tipo = tipo;

    }
    public int getTipo() {
        return this.tipo;
    }
    
}
