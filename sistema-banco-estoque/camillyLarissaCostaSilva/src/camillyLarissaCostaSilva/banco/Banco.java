package camillyLarissaCostaSilva.banco;

import java.util.ArrayList;

public class Banco {
	
		private ArrayList<Conta> contas = new ArrayList<Conta>();
		
	    public boolean adicionar(Conta c) {
	      	Conta outra = pesquisar(c.getNumero());
	      	if (outra != null) {
	    		return false;	
	    	}
	    	contas.add(c);
	    	return true;
	    }
	    
	    public boolean saque(int num, double val, String senha) {
	      	Conta c = pesquisar(num);
	      	if (c != null) {
	      		if (c.getDono().getSenha() == senha) {
	    			return c.debito(val);
	    		}
	    	}
	    	return false;    
	    }
	    
	    public boolean juros(int num, double t, String senha) {
	      	Conta c = pesquisar(num);
	      	if (c != null) {
	      		if (c.getDono().getSenha() == senha) {
	      			if (c instanceof Poupanca)
	    			  return ((Poupanca) c).rendeJuros(t);
	      			else
	      			  return false;
	    		}
	    	}
	    	return false;    
	    }
	    
	    public boolean deposito(int num, double val, String senha) {
	      	Conta c = pesquisar(num);
	      	if (c != null) {
	      		if (c.getDono().getSenha() == senha) {
	    			c.credito(val);
	    			return true;
	    		}
	    	}
	    	return false;    
	    }
	    
	    public boolean transferencia(int numOrigem, int numDestino, double val, String senha) {
	      	Conta de = pesquisar(numOrigem);
	      	if (de != null) {
	      		if (de.getDono().getSenha() == senha) {
	      			Conta para = pesquisar(numDestino);
	      			if (para != null) {
	      				de.debito(val);
	    			    para.credito(val);
	        			return true;
	      			} 
	    		}
	    	}
	    	return false;    
	    }
	    
	    public String extrato(int num, String senha) {
	      	Conta c = pesquisar(num);
	      	if (c != null) {
	      		if (c.getDono().getSenha() == senha) {
	    			return c.getExtrato();
	      		}
	      	}
	    	return "";    
	    }
	    
	    public double saldo(int num, String senha) {
	      	Conta c = pesquisar(num);
	      	if (c != null) {
	      		if (c.getDono().getSenha() == senha) {
	    			return c.getSaldo();
	      		}
	      	}
	    	return -999999;     
	    }
	    
	    private Conta pesquisar(int num) {
	    	for (Conta c : contas) {
	    		if (c.getNumero() == num) {
	    			return c;
	    		}
			}
	     	return null;
	    } 
}
