package camillyLarissaCostaSilva.estoque;

import static org.junit.Assert.*;

import org.junit.Test;
	
public class EstoqueTest {
	@Test
	public void testarIncluirProduto() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50.0);
		e.incluir(p);
		
		assertTrue(e.produtos.contains(p));
		assertEquals("Pera", p.getDesc());
		assertEquals(10, p.getMin(), 0.001);
	}

	@Test
	public void testarIncluirProdutoJaExistente() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50.0);
		Produto p2 = new Produto(321, "Maca", 10, 50.0);
		Produto p3 = new Produto(321, "Uva", 10, 50.0);
		e.incluir(p);
		e.incluir(p2);
		e.incluir(p3);
		
		assertTrue(e.produtos.contains(p));
		assertTrue(e.produtos.contains(p2));
		assertFalse(e.produtos.contains(p3));
	}
	
	@Test
	public void testarCompra() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertTrue(e.produtos.contains(p));
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);	
		assertEquals(2.5, e.precoDeVenda(123), 0.001);	
		
		e.comprar(123, 10, 3);
		
		assertEquals(20, e.quantidade(123), 0.001);
		assertEquals(2.75, e.precoDeCompra(123), 0.001);	
		assertEquals(3.0, e.precoDeVenda(123), 0.001);
	}
	
	@Test
	public void testarCompraQuantidadePrecoNegativo() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
	
		e.comprar(123, -1111111, 2.5);
		
		assertEquals(0, e.quantidade(123), 0.001);	
		assertEquals(0, e.precoDeCompra(123), 0.001);	
		assertEquals(0, e.precoDeVenda(123), 0.001);	
		
		e.comprar(123, 10, -111111);
		
		assertEquals(0, e.quantidade(123), 0.001);	
		assertEquals(0, e.precoDeCompra(123), 0.001);	
		assertEquals(0, e.precoDeVenda(123), 0.001);
	}
	
	@Test
	public void testarCompraProdutoNaoExistente() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(111, 10, 2.5);
		
		assertEquals(0, e.quantidade(123), 0.001);	
		assertEquals(0, e.precoDeCompra(123), 0.001);	
		assertEquals(0, e.precoDeVenda(123), 0.001);
	}
	@Test
	public void testarVenda() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);	
		assertEquals(2.5, e.precoDeVenda(123), 0.001);	
		assertEquals(12.5, e.vender(123, 5), 0.001);
		assertEquals(5, e.quantidade(123), 0.001);
	}
	
	@Test
	public void testarVendaQuantidadeNegativa() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);	
		assertEquals(3.75, e.precoDeVenda(123), 0.001);	
		
		assertEquals(-1, e.vender(123, -111), 0.001);
		assertEquals(10, e.quantidade(123), 0.001);
		
	}
	@Test
	public void testarVendaQuantidadeCompraMaiorQuantidadeEstoque() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);	
		assertEquals(3.75, e.precoDeVenda(123), 0.001);	
		
		assertEquals(-1, e.vender(123, 1000), 0.001);
		assertEquals(10, e.quantidade(123), 0.001);
		
	}
	
	@Test
	public void testarVendaProdutoNaoExistente() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);	
		assertEquals(3.75, e.precoDeVenda(123), 0.001);	
		
		assertEquals(-1, e.vender(111, 5), 0.001);
		assertEquals(10, e.quantidade(123), 0.001);
		
	}
	
	@Test
	public void testarQuantidade() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
	}
	
	@Test
	public void testarQuantidadeProdutoNaoExistente() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(-1, e.quantidade(111), 0.001);	
	}
	
	@Test
	public void testarMovimentacao() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);	
		assertEquals(2.5, e.precoDeVenda(123), 0.001);
		assertEquals(18.75, e.vender(123, 5), 0.001);
		assertEquals("Compra -  Quantidade Comprada: 10 Valor: 2.5 Quantidade Atual: 10\n" +
				"Venda - Quantidade Vendida: 5 Valor vendido: 18.75 Quantidade Atual: 5\n", e.movimentacao(123));
	}
	
	@Test
	public void testarMovimentacaoErrada() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);	
		assertEquals(3.75, e.precoDeVenda(123), 0.001);
		assertEquals("", e.movimentacao(111));
	}
	
	@Test
	public void testarArrayEstoqueMinimo() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		Produto m = new Produto(321, "Morango", 10, 50);
		Fornecedor f = new Fornecedor(444, "Camil");
		
		e.incluir(p);
		e.incluir(m);
		e.adicionarFornecedor(123, f);
		e.adicionarFornecedor(321, f);
		e.comprar(321, 10, 2.5);
		
		assertEquals(0, e.quantidade(123), 0.001);
		assertEquals(10, e.quantidade(321), 0.001);
		System.out.println(e.estoqueAbaixoDoMinimo());
		}
	
	@Test
	public void testarArrayFornecedores() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		Fornecedor f = new Fornecedor(444, "Camil");
		Fornecedor o = new Fornecedor(332, "Dellys");
		e.incluir(p);
		e.adicionarFornecedor(123, f);
		e.adicionarFornecedor(123, o);
		
		assertTrue(e.produtos.contains(p));
		System.out.println(e.fornecedores(123));
		
		}
	
	@Test
	public void testarArrayFornecedoresContaNaoExistente() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		Fornecedor f = new Fornecedor(444, "Camil");
		e.incluir(p);
		e.adicionarFornecedor(123, f);
		
		assertTrue(e.produtos.contains(p));
		assertEquals(null, e.fornecedores(111));
		}
	
	@Test
	public void testarAdicionarFornecedor() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		Fornecedor f = new Fornecedor(444, "Dellys");
		
		e.incluir(p);
		e.adicionarFornecedor(123, f);
		f.setCnpj(234);
		f.setNome("Camil");
		
		assertTrue(e.produtos.contains(p));
		assertEquals(234, f.getCnpj(), 0.001);
		assertEquals("Camil", f.getNome());
		
		System.out.println("Fornecedores produto 1: " + e.fornecedores(123));
	}
	
	@Test
	public void testarAdicionarFornecedorProdutoNaoExiste() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		Fornecedor f = new Fornecedor(123, "Camil");
		
		e.incluir(p);
		e.adicionarFornecedor(111, f);
		
		assertTrue(e.produtos.contains(p));
		assertEquals(null, e.fornecedores(123));		
	}
	
	@Test
	public void testarAdicionarFornecedorNaoExiste() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		
		e.incluir(p);
		
		assertTrue(e.produtos.contains(p));
		assertEquals(null, e.fornecedores(123));		
	}
	
	@Test
	public void testarPrecoDeVenda() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);	
		assertEquals(3.75, e.precoDeVenda(123), 0.001);	
		
		e.comprar(123, 90, 1);
		
		assertEquals(100, e.quantidade(123), 0.001);
		assertEquals(1.15, e.precoDeCompra(123), 0.001);
		assertEquals(1.15, e.precoDeVenda(123), 0.001);
	}
	
	@Test
	public void testarPrecoDeVendaProdutoNaoExistente() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10, 2.5);
		
		assertEquals(10, e.quantidade(123), 0.001);	
		assertEquals(2.5, e.precoDeCompra(123), 0.001);
		
		assertEquals(-1, e.precoDeVenda(111), 0.001);	
	}
	
	@Test
	public void testarPrecoDeCompra() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10000, 1.5);
		
		assertEquals(10000, e.quantidade(123), 0.001);	
		assertEquals(1.5, e.precoDeCompra(123), 0.001);	
		assertEquals(1.5, e.precoDeVenda(123), 0.001);	
		
		e.comprar(123, 10000, 1.375);
		
		assertEquals(20000, e.quantidade(123), 0.001);
		assertEquals(1.4375, e.precoDeCompra(123), 0.001);
		assertEquals(1.4375, e.precoDeVenda(123), 0.001);
	}
	
	@Test
	public void testarPrecoDeCompraProdutoNaoExistente() {
		Estoque e = new Estoque();
		Produto p = new Produto(123, "Pera", 10, 50);
		e.incluir(p);
		e.comprar(123, 10000, 1.5);
		
		assertEquals(10000, e.quantidade(123), 0.001);	
		assertEquals(-1, e.precoDeCompra(111), 0.001);	
	}
}
