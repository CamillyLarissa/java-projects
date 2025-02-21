package camillyLarissaCostaSilva.locadora;


public class ClienteInexistente extends Exception {
	

	public ClienteInexistente(int cpf) {
		super("Cliente inexistente. CPF: " + cpf);
	}
}