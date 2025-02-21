package camillyLarissaCostaSilva.locadora;


public class Onibus extends Veiculo {
    
    private int capacidadePassageiros;

    public Onibus(String marca, String modelo, int anoFabricacao, double valorAvaliado, double valorDiaria,String placa, int passageiros) {
        super(marca, modelo, anoFabricacao, valorAvaliado, valorDiaria, placa);
        this.capacidadePassageiros = passageiros;
    }

    public double getValorAluguel(int dias) {
        return (this.valorDiaria + this.seguro()) * dias;
    }
    
    public double seguro() {
    	return ((this.valorAvaliado * 0.2)/365);
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

    public int getPassageiros() {
        return this.capacidadePassageiros;
    }

    public void setPassageiros(int passageiros) {
        this.capacidadePassageiros = passageiros;
    }

}
