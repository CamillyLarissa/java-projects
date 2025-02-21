package camillyLarissaCostaSilva.locadora;

import java.util.ArrayList;
import java.util.Date;

public class MinhaLocadora extends Locadora{

	ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	ArrayList<Movimentacao> movimentacao = new ArrayList<Movimentacao>();
	
	
	@Override
	public void inserir(Veiculo v) throws VeiculoJaCadastrado, DadosInvalidos {
		Veiculo veiculo;
		
		if(v.getMarca().isEmpty() || v.getMarca() == null || v.getModelo().isEmpty() || v.getModelo() == null || 
							v.getAnoDeFabricacao() < 0 || v.getValorAvaliado() < 0 || v.getValorDiaria() <0 ||
							v.getPlaca().isEmpty() || v.getPlaca() == null)  {
			
			throw new DadosInvalidos();
		}
		
		if(v instanceof Moto) {
			if(((Moto) v).getCilindrada() < 0) {
				throw new DadosInvalidos();
			}
		}else if(v instanceof Carro) {
			if(((Carro) v).getTipo() < 0 || ((Carro) v).getTipo() > 3) {
				throw new DadosInvalidos();
			}
		}else if(v instanceof Caminhao) {
			if(((Caminhao) v).getCapacidadeCarga() < 0) {
				throw new DadosInvalidos();
			}
		}else if(v instanceof Onibus) {
			if(((Onibus) v).getPassageiros() < 0) {
				throw new DadosInvalidos();
			}
		}
		
		try {
			veiculo = pesquisar(v.getPlaca());
		} catch (VeiculoInexistente e) {
			veiculos.add(v);
			return;
			
		}
		throw new VeiculoJaCadastrado(v.getPlaca());
	}
	
	 protected Veiculo pesquisar(String placa) throws VeiculoInexistente, DadosInvalidos {
		 	if(placa == null || placa.isEmpty()) {
		 		throw new DadosInvalidos();
		 	}
			for (Veiculo v : veiculos) {
				if (v.getPlaca() == placa) {
					return v;
				}
			}
			throw new VeiculoInexistente(placa);
		}

	@Override
	public ArrayList<Veiculo> pesquisarMoto(int cilindrada) throws DadosInvalidos {
		ArrayList<Veiculo> motosPesquisadas = new ArrayList<Veiculo>();
		
		if(cilindrada < 0) {
			throw new DadosInvalidos();
		}
		for (Veiculo v : veiculos) {
			if (v instanceof Moto) {
				if(((Moto) v).getCilindrada() >= cilindrada){		
					motosPesquisadas.add(v);
				}
			}
		}
		return motosPesquisadas;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) throws DadosInvalidos {
		
		ArrayList<Veiculo> carrosPesquisados = new ArrayList<Veiculo>();
		carrosPesquisados.clear();
				
		if(tipoCarro < 0 || tipoCarro > 3) {
			throw new DadosInvalidos();
		}
		for (Veiculo v : veiculos) {
			if (v instanceof Carro) {
				if(tipoCarro == 0) {
					carrosPesquisados.add(v);
				}else {
					if(((Carro) v).getTipo() == tipoCarro){		
						carrosPesquisados.add(v);
					}
				}
			}
		}
		return carrosPesquisados;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCaminhao(int carga) throws DadosInvalidos {
		
		ArrayList<Veiculo> caminhoesPesquisados = new ArrayList<Veiculo>();
		
		if(carga < 0) {
			throw new DadosInvalidos();
		}
		for (Veiculo v : veiculos) {
			if (v instanceof Caminhao) {
				if(((Caminhao) v).getCapacidadeCarga() >= carga){		
					caminhoesPesquisados.add(v);
				}
			}
		}
		return caminhoesPesquisados;
	}

	@Override
	public ArrayList<Veiculo> pesquisarOnibus(int passageiros) throws DadosInvalidos {
		ArrayList<Veiculo> onibusPesquisados = new ArrayList<Veiculo>();
		
		if(passageiros < 0) {
			throw new DadosInvalidos();
		}
		for (Veiculo v : veiculos) {
			if (v instanceof Onibus) {
				if(((Onibus) v).getPassageiros() >= passageiros){		
					onibusPesquisados.add(v);
				}
			}
		}
		return onibusPesquisados;
	}

	@Override
	public double calcularAluguel(String placa, int dias) throws VeiculoInexistente, DadosInvalidos {
		Veiculo veiculo;
		double valor = 0;
		
		if(placa == null || placa.isEmpty() || dias < 0) {
			throw new DadosInvalidos();
		}
		try {
			veiculo = pesquisar(placa);
		} catch (VeiculoInexistente e) {
			throw new VeiculoInexistente(placa);
		}
		
		if(veiculo instanceof Moto) {
			valor = ((Moto)veiculo).getValorAluguel(dias);
		}else if(veiculo instanceof Carro) {
			valor = ((Carro)veiculo).getValorAluguel(dias);
		}else if(veiculo instanceof Caminhao) {
			valor = ((Caminhao)veiculo).getValorAluguel(dias);
		}else if(veiculo instanceof Onibus) {
			valor = ((Onibus)veiculo).getValorAluguel(dias);
		}
		
		valor = Math.round(valor * 100.0) / 100.0;
		return valor;
	}

	@Override
	public boolean registrarAluguel(String placa, Date data, int dias, int cpf)
			throws VeiculoInexistente, ClienteInexistente, DadosInvalidos, VeiculoJaAlugado {
		Veiculo veiculo;
		Cliente cliente;
		Date hoje = new Date();
		
		if(placa == null || placa.isEmpty() || dias < 0 || cpf < 0 || hoje.before(data)) {
			throw new DadosInvalidos();
		}
		try {
			veiculo = pesquisar(placa);
		} catch (VeiculoInexistente e) {
			throw new VeiculoInexistente(placa);
		}
		try {
			cliente = pesquisarCliente(cpf);
		} catch (ClienteInexistente e) {
			throw new ClienteInexistente(cpf);
		}
		for (Aluguel a : alugueis) {
			if (a.getVeiculo().getPlaca() == placa) {
				if(a.getAlugado() == true) {
					throw new VeiculoJaAlugado(placa);
				}
			}
		}
		alugueis.add(new Aluguel(veiculo, hoje, dias, cliente, this.calcularAluguel(placa, dias), true));
		movimentacao.add(new Movimentacao(veiculo, hoje, this.calcularAluguel(placa, dias),dias));
		return true;
}

	@Override
	public boolean registrarDevolucao(String placa) throws VeiculoInexistente, VeiculoNaoAlugado, DadosInvalidos {
		Veiculo veiculo;
		Aluguel aluguel = null;
		
		if(placa.isEmpty() || placa == null) {
			throw new DadosInvalidos();
		}
		try {
			veiculo = pesquisar(placa);
		} catch (VeiculoInexistente e) {
			throw new VeiculoInexistente(placa);
		}
		for (Aluguel a : alugueis) {
			if (a.getVeiculo().getPlaca() == placa) {
				aluguel = a;
				break;
			}
		}
		if(aluguel.getAlugado() == false) {
			throw new VeiculoNaoAlugado(placa);
		}
		aluguel.setAlugado(false);
		aluguel.setCliente(null);
		aluguel.setValor(0);
		aluguel.setData(null);
		aluguel.setDias(0);
		return true;
	}
	
	
	@Override
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) throws DadosInvalidos {
		
		if(taxaDepreciacao < 0 || tipo < 0 || tipo > 4) {
			throw new DadosInvalidos();
		}
		if(tipo == 0) {
			for(Veiculo v: veiculos) {
				v.reduzirValorAvaliado(taxaDepreciacao);
			}
		}else if(tipo == 1) {
			for(Veiculo v: veiculos) {
				if(v instanceof Moto) {
					v.reduzirValorAvaliado(taxaDepreciacao);
				}
			}
		}else if(tipo == 2) {
			for(Veiculo v: veiculos) {
				if(v instanceof Moto) {
					v.reduzirValorAvaliado(taxaDepreciacao);
				}
			}
			
		}else if(tipo ==3) {
			for(Veiculo v: veiculos) {
				if(v instanceof Caminhao) {
					v.reduzirValorAvaliado(taxaDepreciacao);
				}
			}
			
		}else if(tipo == 4) {
			for(Veiculo v: veiculos) {
				if(v instanceof Onibus) {
					v.reduzirValorAvaliado(taxaDepreciacao);
				}
			}
			
		}
	}

	@Override
	public void aumentarDiaria(int tipo, double taxaAumento) throws DadosInvalidos {
		if(taxaAumento < 0 || tipo < 0 || tipo > 4) {
			throw new DadosInvalidos();
		}
		if(tipo == 0) {
			for(Veiculo v: veiculos) {
				v.aumentarDiaria(taxaAumento);

			}
		}else if(tipo == 1) {
			for(Veiculo v: veiculos) {
				if(v instanceof Moto) {
					v.aumentarDiaria(taxaAumento);
									}
			}
		}else if(tipo == 2) {
			for(Veiculo v: veiculos) {
				if(v instanceof Carro) {
					v.aumentarDiaria(taxaAumento);
					
				}
			}
			
		}else if(tipo ==3) {
			for(Veiculo v: veiculos) {
				if(v instanceof Caminhao) {
					v.aumentarDiaria(taxaAumento);
					
				}
			}
			
		}else if(tipo == 4) {
			for(Veiculo v: veiculos) {
				if(v instanceof Onibus) {
					v.aumentarDiaria(taxaAumento);
				}
			}
			
		}
	}
		
	@Override
	public double faturamentoTotal(int tipo, Date inicio, Date fim) throws DadosInvalidos {
		double faturamento = 0;
		
		if(tipo < 0 || tipo > 4 || inicio == null || fim == null || inicio.after(fim)) {
			throw new DadosInvalidos();
		}
		
		if(tipo == 0){
			for(Movimentacao m : movimentacao) {
				if (m.getData().after(inicio) && m.getData().before(fim)) {
					faturamento += m.getValor();
				}
			}
		}else if(tipo == 1){
			for (Movimentacao m : movimentacao) {
				if(m.getVeiculo() instanceof Moto) {
					if (m.getData().after(inicio) && m.getData().before(fim)) {
						faturamento += m.getValor();
					}
				}
			}
		}else if(tipo == 2){
			for (Movimentacao m : movimentacao) {
				if(m.getVeiculo() instanceof Carro) {
					if (m.getData().after(inicio) && m.getData().before(fim)) {
						faturamento += m.getValor();
					}
				}
			}
		}else if(tipo == 3){
			for (Movimentacao m : movimentacao) {
				if(m.getVeiculo() instanceof Caminhao) {
					if (m.getData().after(inicio) && m.getData().before(fim)) {
						faturamento += m.getValor();
					}
				}
			}	
		}else if(tipo == 4){
			for (Movimentacao m : movimentacao) {
				if(m.getVeiculo() instanceof Onibus) {
					if (m.getData().after(inicio) && m.getData().before(fim)) {
						faturamento += m.getValor();
					}
				}
			}	
		}
		faturamento = Math.round(faturamento * 100.0) / 100.0;
		return faturamento;
		}
	

	@Override
	public int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim) throws DadosInvalidos {
		int quantidadeDiarias = 0;
		
		if(tipo < 0 || tipo > 4 || inicio == null || fim == null || inicio.after(fim) ) {
			throw new DadosInvalidos();
		}
		if(tipo == 0) {
			for(Movimentacao m : movimentacao) {
				if (m.getData().after(inicio) && m.getData().before(fim)){
					quantidadeDiarias += m.getDias();
				}
			}	
		}else if(tipo == 1) {
			for(Movimentacao m : movimentacao) {
				if(m.getVeiculo() instanceof Moto) {
					if (m.getData().after(inicio) && m.getData().before(fim)) {
						quantidadeDiarias += m.getDias();
					}	
				}	
			}
		}else if(tipo == 2) {
			for(Movimentacao m : movimentacao) {
				if(m.getVeiculo() instanceof Carro) {
					if (m.getData().after(inicio) && m.getData().before(fim)){
						quantidadeDiarias += m.getDias();
					}
				}
			}	
			
		}else if(tipo ==3) {
			for(Movimentacao m : movimentacao) {
				if(m.getVeiculo() instanceof Caminhao) {
					if (m.getData().after(inicio) && m.getData().before(fim)){
						quantidadeDiarias += m.getDias();
					}
				}
			}	
			
		}else if(tipo == 4) {
			for(Movimentacao m : movimentacao) {
				if(m.getVeiculo() instanceof Onibus) {
					if (m.getData().after(inicio) && m.getData().before(fim)){
						quantidadeDiarias += m.getDias();
				}
			}		
		}
	}
		return quantidadeDiarias;
	}
}



