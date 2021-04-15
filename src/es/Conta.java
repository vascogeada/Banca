package es;

/**
 * Representa uma conta banc�ria.
 * 
 * Funciona como um conta � ordem, sem juros nem comiss�es.
 * Com simples opera��es de Levantar, Depositar e Transferir.
 * 
 * Foi implementada a Boa Pr�tica de Verificar a Validade dos Par�metros,
 * @see <a href="https://kea.nu/files/textbooks/new/Effective%20Java%20%282017%2C%20Addison-Wesley%29.pdf" target="_blank">Item 49 Check Parameters for Validity</a>  
 * @see <a href="https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997" target="_blank">Effective Java</a>
 * 
 * 
 * @author antrob
 */
public class Conta {
	
	/**
	 * Montante m�nimo de abertura de conta
	 * 
	 */
	public static final double MONTANTE_MINIMO = 100.0;
	
	// Por simplicidade escolhemos o tipo double, 
	// apesar de n�o ser o indicado para c�lculo monet�rio/financeiro
	private double saldo;

	
	// Acessores 
	
	/**
	 * Para consulta do saldo da conta.
	 * 
	 * @return a quantia existente na conta
	 */
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	// Construtores 
	
	



	/**
	 * Constr�i uma conta igualando o saldo ao {@link #MONTANTE_MINIMO MONTANTE_MINIMO} de abertura da conta.
	 * 
	 */
	public Conta() {
		saldo = MONTANTE_MINIMO;
		
	}
	
	/**
	 * Constr�i uma conta com saldo inicial igual ao valor passado como par�metro. 
	 * 
	 * O saldo inicial da conta n�o pode ser inferior ao {@link #MONTANTE_MINIMO MONTANTE_MINIMO}.  
	 * 
	 * @param saldoInicial saldo inicial da conta
	 * @throws IllegalArgumentException se o valor de do saldoInicial for inferior ao {@link #MONTANTE_MINIMO MONTANTE_MINIMO}
	 */
	public Conta(double saldoInicial) {
		
		if (saldoInicial > MONTANTE_MINIMO)
			saldo = saldoInicial;
		else
			throw new AssertionError("O saldo � inferior ao montante m�nimo");
	}
	
	// M�todos 
	
	/**
	 * Depositar uma determinada quantia na conta.
	 *  
	 * @param quantia valor a depositar 
	 * @throws IllegalArgumentException se a quantia a depositar for inferior ou igual a zero
	 */
	public void depositar( double quantia ) {
		
		if(quantia > 0)
			setSaldo(getSaldo() + quantia);
		else 
			throw new AssertionError("O saldo � inferior a 0");
		
	}
	
	
	/**
	 * Levantar uma determinada quantia na conta.
	 * 
	 * @param quantia valor a levantar
	 * @throws IllegalArgumentException se a quantia a depositar for inferior ou igual a zero,
	 *         ou se a conta n�o tiver saldo suficiente para efectuar o levantamento
	 * 
	 */
	public void levantar( double quantia ) { 
		
		if(quantia > 0 || getSaldo() < quantia)
			setSaldo(getSaldo() + quantia);
		else 
			throw new AssertionError("Precisa de inserir um montante v�lido");
	}
	
	
	/**
	 * Transferir da conta corrente para a conta destino
	 * 
	 * @param contaDestino a conta que ir� receber o montante da transfer�ncia 
	 * @param montante o montante da transfer�ncia
	 * @throws IllegalArgumentException se o montante a transferir for inferior ou igual a zero,
	 *         ou se a conta origem da transfer�ncia n�o tiver saldo suficiente para efectuar a transfer�ncia
	 * @throws NullPointerException caso o par�metro contaDestino seja null        
	 */
	public void transferir( Conta contaDestino, double montante ) { 
		
		if (contaDestino == null)
			throw new AssertionError("A conta destino n�o � valida");
		else if (montante < 0 || getSaldo() < montante )
			throw new AssertionError("Precisa de inserir um montante v�lido");
		else {
			setSaldo(getSaldo() - montante);
			contaDestino.setSaldo(getSaldo() + montante);
		}
	}

}
