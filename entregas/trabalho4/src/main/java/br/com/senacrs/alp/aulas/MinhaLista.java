package br.com.senacrs.alp.aulas;

public class MinhaLista<T> implements Lista<T> {

	private Nodo<T> inicio = new Nodo<T>();

	@Override
	public void adicionarFinal(T valor) {

		adicionarPosicao(obterTamanho(), valor);

	}

	@Override
	public void adicionarInicio(T valor) {

		adicionarPosicao(0, valor);

	}

	@Override
	public void adicionarPosicao(int posicao, T valor) {

		Nodo<T> nodo =	null;
		Nodo<T> novo =	new Nodo<T>();
		nodo = obterNodoPosicao(posicao - 1);
		novo.apontamento = nodo.apontamento;
		nodo.apontamento = novo;
		novo.conteudo = valor;

	}

	@Override
	public T obterPrimeiro() {

		Nodo<T> nodo =	null;
		nodo = obterNodoPosicao(0);
		return nodo.conteudo;

	}

	@Override
	public T obterUltimo() {

		int tamanho = obterTamanho();
		T resultado = obterPosicao(tamanho - 1);
		return resultado;

	}

	@Override
	public T obterPosicao(int posicao) {

		Nodo<T> nodo =	null;
		nodo = obterNodoPosicao(posicao);
		return nodo.conteudo;

	}

	@Override
	public int obterTamanho() {

		int resultado = 0;
		Nodo<T> nodo =	null;
		nodo =	inicio;
		while (nodo.apontamento != null) {
			nodo = nodo.apontamento;
			resultado++;

		}

		return resultado;

	}

	@Override
	public T removerPosicao(int posicao) {

		Nodo<T> nodo =	null;
		Nodo<T> anterior =	new Nodo<T>();
		nodo = obterNodoPosicao(posicao);
		anterior = obterNodoPosicao(posicao - 1);
		anterior.apontamento = nodo.apontamento;
		nodo.apontamento = null;
		T resultado = nodo.conteudo;
		return resultado;
		
	}
	
	private Nodo<T> obterNodoPosicao(int posicao) {

		Nodo<T> nodo = inicio;
		int indice = -1;
		while (posicao != indice) {
			nodo = nodo.apontamento;
			indice++;
		}
		return nodo;

	}

	@Override
	public void esvaziar() {

		inicio.apontamento = null;

	}

	

}
