package es;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testConta() {
		Conta conta = new Conta();
		
		if(conta.getSaldo() != Conta.MONTANTE_MINIMO){
			fail("O saldo não é igual ao montante mínimo");
		}
	}

	@Test
	void testContaDouble() {
		Conta conta = new Conta(1000);
		
		if(conta.getSaldo() < Conta.MONTANTE_MINIMO){
			fail("Precisa de inserir um montante maior que o definido para abrir uma conta");
		}
	}

	@Test
	void testDepositar() {
		//Declaração da conta
		Conta conta = new Conta();
		
		// definir o saldo antigo
		double saldoAntigo = conta.getSaldo();
		// definir o montante
			double montante = 5;
		
		//testar depositar saldo negativo
		conta.depositar(montante);
		
		//Verificar se o montante depositado é maior que 0
		if(montante <= 0){
			fail("Precisa de inserir um montante maior que zero para poder efetuar o depósito");
		}
	}

	@Test
	void testLevantar() {
		//Declaração da conta
		Conta conta = new Conta();
		
		// definir o saldo antigo
		double saldoAntigo = conta.getSaldo();
		// definir o montante
			double montante = 1;
		
		//testar depositar saldo negativo
		conta.levantar(montante);
		
		//Verificar se o montante depositado é maior que 0
		if(montante <= 0){
			fail("Precisa de inserir um montante maior que zero para poder efetuar o depósito");
		}
	}

	@Test
	void testTransferir() {
		//Declaração da conta
		Conta conta = new Conta(1000);
		Conta contaDestino = new Conta();
		
		// definir o montante
		double montante = 20;
		
		//testar depositar saldo negativo
		if (montante <= 0 || conta.getSaldo() < montante)
			fail("Precisa de inserir um montante maior que zero para poder efetuar o depósito");
		else if (contaDestino == null) 
			fail("Precisa de uma conta destino válida");
		 else
			conta.transferir(contaDestino, 20);

	}

}
