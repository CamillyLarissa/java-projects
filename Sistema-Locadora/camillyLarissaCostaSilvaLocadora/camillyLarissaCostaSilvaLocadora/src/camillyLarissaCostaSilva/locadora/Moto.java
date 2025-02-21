package camillyLarissaCostaSilva.locadora;

public class Moto extends Veiculo {
    
    private int cilindrada;

    public Moto(String marca, String modelo, int anoFabricacao, double valorAvaliado, double valorDiaria,String placa, int cilindrada) {
        super(marca, modelo, anoFabricacao, valorAvaliado, valorDiaria, placa);
        this.cilindrada = cilindrada;    
    }

    public double getValorAluguel(int dias) {
        return (this.valorDiaria + this.seguro())* dias;
    }
    
    public double seguro() {
    	return ((this.valorAvaliado * 0.11)/365);
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

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return this.cilindrada;
    }

    
}
