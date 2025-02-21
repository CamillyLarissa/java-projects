package camillyLarissaCostaSilva.banco;

public class Poupanca extends Conta{
	public Poupanca(int n) {
		super(n);
	}

	public boolean rendeJuros(double t) {
		double rendimento = getSaldo() * t;
		credito(rendimento);
		return true;
	}
}
