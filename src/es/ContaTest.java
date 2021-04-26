package es;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		/*if(conta.getSaldo() != Conta.MONTANTE_MINIMO){
			fail("O saldo não é igual ao montante mínimo");
		}*/
		
		assertEquals(Conta.MONTANTE_MINIMO, conta.getSaldo(), "O saldo não é igual ao montante mínimo");
	}

	@Test
	void testContaDouble() {
		//Teste 1
		Conta conta = new Conta(100.0);
		assertEquals(100.0, conta.getSaldo(), "Precisa de inserir um montante maior que o definido para abrir uma conta");
		
		//Teste 2
		assertThrows(IllegalArgumentException.class, () -> {
			new Conta(80.0);
		}, "Precisa de inserir um montante maior que o #MONTANTE_MINIMO" );

		
		
	}

	@Test
	void testDepositar() {
		//TESTE 1
		Conta conta = new Conta();
		double saldoAntesDeposito = conta.getSaldo();
		double montante = 140.0;
		conta.depositar(montante);
		assertEquals(saldoAntesDeposito + montante, conta.getSaldo(), "O saldo deve ser igual ao saldo antes do deposito mais o valor depositado");
		
		//TESTE 2
		Conta conta2 = new Conta(100.0);
		assertThrows(IllegalArgumentException.class, () -> {
			conta2.depositar(0);
		}, "Precisa de inserir um montante maior que 0" );
		
	}

	@Test
	void testLevantar() {
		//Teste 1
		Conta conta = new Conta();
		
		// definir o saldo antigo
		double saldoAntigo = conta.getSaldo();
		
		conta.levantar(5);
		
		assertEquals(saldoAntigo - 5, conta.getSaldo(), "O saldo tem que ser igual ao saldo antigo - montante");
		
		//teste 2
		Conta conta2 = new Conta();
		assertThrows(IllegalArgumentException.class, () -> {
			conta2.levantar(-5);
		}, "Precisa de inserir um montante maior que 0 e tem que ser menor que o seu saldo atual" );
		
		//teste 3
			Conta conta3 = new Conta();
			double saldoAntigoConta3 = conta3.getSaldo();
			assertThrows(IllegalArgumentException.class, () -> {
				conta3.levantar(saldoAntigoConta3 + 50);
				
			}, "Não pode levantar uma quantia superior ao saldo atual" );
	}

	@Test
	void testTransferir() {
		
		Conta conta = new Conta(100);
		Conta c1 = new Conta();
		//Teste 1
		
		
		double contaSaldoAntigo = conta.getSaldo();		
		double contaDestinoSaldoAntigo = c1.getSaldo();
		
		conta.transferir(c1, 5);
		
		assertEquals(contaSaldoAntigo - 5, conta.getSaldo(), "O saldo tem que ser igual ao saldo antigo - montante");
		assertEquals(contaDestinoSaldoAntigo + 5, c1.getSaldo(), "O saldo tem que ser igual ao saldo antigo - montante");
		
		
		//testar 2 - fail
	//	contaSaldoAntigo = conta.getSaldo();		
		//contaDestinoSaldoAntigo = conta.getSaldo();
		conta.levantar(90);
		
		assertThrows(IllegalArgumentException.class, () -> {
		  conta.transferir(c1, 100);
		  conta.transferir(c1, -5);
		}, "Precisa de inserir um montante maior que 0 e precisa de ter um saldo superior ao da transferência " );
		
		//Teste 3 - fail

		assertThrows(NullPointerException.class, () -> {
			Conta conta6 = null;
			conta.transferir(conta6, 100);
		}, "Precisa de enviar o montante para uma conta válida" );
	}

}
