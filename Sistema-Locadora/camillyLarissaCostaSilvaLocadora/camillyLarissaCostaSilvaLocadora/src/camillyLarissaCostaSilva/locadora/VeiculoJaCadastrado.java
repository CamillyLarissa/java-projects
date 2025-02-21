package camillyLarissaCostaSilva.locadora;

public class VeiculoJaCadastrado extends Exception {


	public VeiculoJaCadastrado(String placa) {
		super("Veiculo ja cadastrado. Placa: " + placa);
	}
}