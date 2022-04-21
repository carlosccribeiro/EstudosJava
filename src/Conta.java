

public abstract class Conta {
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;
	
	
	
	public Conta(int agencia, int numero) {
		Conta.total++;
		this.agencia = agencia;
		this.numero = numero;
		//this.saldo = 100;
		//System.out.println("total de contas: "+ total);
		//System.out.println("Criando a conta: "+ this.numero);
		
	}
	
	public abstract void deposita(double valor);
	
	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
		
	}
	public boolean transferir(double valor, Conta destino) {
		if (this.saca(valor)) {
			destino.deposita(valor);
			return true;
		}
		return false;
				
	}
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(agencia <= 0 ) {
			System.out.println("Valor menor que 0 proibido");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0 ) {
			System.out.println("Valor menor que 0 proibido");
			return;
		}
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
}