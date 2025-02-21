package camillyLarissaCostaSilva.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class BancoTest {
	
	@Test
	public void testarCadastroDeConta() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		p1.setNome("Laura");
		
		System.out.println("Nome pessoa 1: " + p1.getNome());
		System.out.println("Cpf pessoa 1: " + p1.getCpf());	
		System.out.println("Conta pessoa 1: " + p1.getConta());
		assertTrue(b.adicionar(c1))	;
	}
	
	@Test
	public void testarCadastroDeContaJaCadastrada() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
        assertTrue(b.adicionar(c1));
		
		Conta c2 = new Conta(1);
		Pessoa p2 = new Pessoa(456, "Paulo");
		p1.setSenha("654321");
		c2.setDono(p2);
		p2.setConta(c2);
		assertFalse(b.adicionar(c2));	
	}
	
	@Test
	public void testarDepositoSaque() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "123456");
		b.saque(1, 50, "123456");
		System.out.println("Saldo conta 1: " + c1.getSaldo());
		assertEquals(100, b.saldo(1, "123456"), 0.001);
	}
	
	@Test
	public void testarDepositoSaquePoupanca() {
		Banco b = new Banco();
		Conta c1 = new Poupanca(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "123456");
		b.saque(1, 50, "123456");
		System.out.println("Saldo poupanca 1: " + c1.getSaldo());
		assertEquals(100, b.saldo(1, "123456"), 0.001);
	}
	
	@Test
	public void testarSaqueAcimaDoSaldo() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "123456");
		b.saque(1, 50, "123456");
		assertEquals(100, b.saldo(1, "123456"), 0.001);
		assertFalse(b.saque(1, 250, "123456"));
		System.out.println("Saldo conta 1: " + c1.getSaldo());
		assertEquals(100, b.saldo(1, "123456"), 0.001);
	}
	
	@Test
	public void testarDepositoESaqueEmContaInexistente() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		assertFalse(b.deposito(2, 150, "123456"));
		assertFalse(b.saque(2, 50, "123456"));
		assertEquals(-999999, b.saldo(2, "123456"), 0.001);
		assertEquals("", b.extrato(2, "999999"));	
	}
	
	@Test
	public void testarDepositoESaqueSenhaIncorreta() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "999999");
		assertEquals(0, b.saldo(1, "123456"), 0.001);
		
		assertFalse(b.saque(1, 50, "999999"));
		assertEquals(0, b.saldo(1, "123456"), 0.001);
		assertEquals(-999999, b.saldo(1, "999999"), 0.001);
		assertEquals("", b.extrato(1, "999999"));
	}
	
	@Test
	public void testarExtrato() {
		Banco b = new Banco();
		Pessoa p1 = new Pessoa(123, "Pedro");
		Conta c1 = new Conta(1);
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "123456");
		b.saque(1, 50, "123456");
		System.out.println("Extrato conta 1: " + c1.getExtrato());
		assertEquals("Crédito: 150.0 Saldo: 150.0\n" + 
				"Débito: 50.0 Saldo: 100.0\n", b.extrato(1, "123456"));
	}
	
	@Test
	public void testarRendimentoJuros() {
		Banco b = new Banco();
		Conta c1 = new Poupanca(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "123456");
		assertEquals(150, b.saldo(1, "123456"), 0.001);
		b.juros(1, 0.01, "123456");
		assertEquals(151.5, b.saldo(1, "123456"), 0.001);
	}
	
	@Test
	public void testarRendimentoJurosErrado() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "123456");
		assertEquals(150, b.saldo(1, "123456"), 0.001);
		assertFalse(b.juros(2, 0.01, "123456"));
		assertFalse(b.juros(1, 0.01, "999999"));
		assertFalse(b.juros(1, 0.01, "123456"));
		assertEquals(150, b.saldo(1, "123456"), 0.001);
	}

	@Test
	public void testarTransferencia() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "123456");

		Conta c2 = new Poupanca(2);
		Pessoa p2 = new Pessoa(456, "Paulo");
		p2.setSenha("654321");
		c2.setDono(p2);
		p2.setConta(c2);
		b.adicionar(c2);
		System.out.println("Saldo conta 2: " + c2.getSaldo());
		assertEquals(0, b.saldo(2, "654321"), 0.001);
		
		b.transferencia(1, 2, 49, "123456");
		assertEquals(49, b.saldo(2, "654321"), 0.001);
		assertEquals(101, b.saldo(1, "123456"), 0.001);
	}
	
	@Test
	public void testarTransferenciaComErro() {
		Banco b = new Banco();
		Conta c1 = new Conta(1);
		Pessoa p1 = new Pessoa(123, "Pedro");
		p1.setSenha("123456");
		c1.setDono(p1);
		p1.setConta(c1);
		b.adicionar(c1);
		b.deposito(1, 150, "123456");

		Conta c2 = new Conta(2);
		Pessoa p2 = new Pessoa(456, "Paulo");
		p2.setSenha("654321");
		c2.setDono(p2);
		p2.setConta(c2);
		b.adicionar(c2);
		System.out.println("Saldo conta 2: " + c2.getSaldo());
		assertEquals(0, b.saldo(2, "654321"), 0.001);
		
		//Tentando transferir de conta inexistente
		assertFalse(b.transferencia(3, 2, 49, "123456"));
		//Tentando transferir de conta com senha errada
		assertFalse(b.transferencia(1, 2, 49, "999999"));
		//Tentando transferir para conta inexistente
		assertFalse(b.transferencia(1, 3, 49, "123456"));
	}

}
