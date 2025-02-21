package camillyLarissaCostaSilva.estoque;

import java.util.ArrayList;

public class Estoque {
	
	public ArrayList<Produto> produtos = new ArrayList<Produto>();
	public ArrayList<Produto> estoqueAbaixoDoMinimo = new ArrayList<Produto>();
	
	public void incluir(Produto p) {
		for (Produto outro : produtos) {
    		if (p.getCod() == outro.getCod()) {
    			return;
    		}
		}
		produtos.add(p);

	}
	
	public void comprar(int cod, int quant, double preco) {
		for (Produto p : produtos) {
    		if (p.getCod() == cod) {
    			if(quant > 0 && preco > 0) {
    				p.compra(quant, preco);
    			}
    		}
		}
	}
	
	public double vender(int cod, int quant) {
		for (Produto p : produtos) {
    		if (p.getCod() == cod) {
    			if(p.quantidade() >= quant && quant > 0) {
    				return p.venda(quant);
    			}	
    		}
	}
		return -1;
	}
	
	public int quantidade(int cod) {
		for (Produto p : produtos) {
    		if (p.getCod() == cod) {
    			return p.quantidade();
    		}	
	}
		return -1;
	}
	
	public String movimentacao(int cod) {
		for (Produto p : produtos) {
    		if (p.getCod() == cod) {
    		      return p.extrato();
    		     }
		}
		return "";
	}
	
	public ArrayList<Produto> estoqueAbaixoDoMinimo(){
		estoqueAbaixoDoMinimo.clear();
		for (Produto p: produtos) {
			if (p.quantidade() < p.getMin()) {
				estoqueAbaixoDoMinimo.add(p);
			}
		}
		return estoqueAbaixoDoMinimo;
	}

	public ArrayList<Fornecedor> fornecedores(int cod){
		for (Produto p : produtos) {
    		if (p.getCod() == cod && p.getFornecedor().isEmpty() == false) {
    			return p.getFornecedor();
    		}
        }
    	return null;
	}

	public void adicionarFornecedor(int cod, Fornecedor f) {
			for (Produto p : produtos) {
	    		if (p.getCod() == cod) {
	    			p.setFornecedor(f);
	    			}
			}
	}
	
	public double precoDeVenda(int cod) {
		for (Produto p : produtos) {
    		if (p.getCod() == cod) {
    			return p.precoDeVenda();
    		}		
    	}
		return -1;
	}
	
	public double precoDeCompra(int cod) {
		for (Produto p : produtos) {
    		if (p.getCod() == cod) {
    			return p.precoDeCompra();
    		}
		}
		return -1;
	}
}
