package ffse1703005.software.atm.model;

import java.sql.Timestamp;

public class Transaction {
	private String codeTransaction;
	private int payTransaction;
	private Timestamp timeTransaction;
	
	public Transaction() {
		
	}
	
	public Transaction(String codeTransaction,Timestamp timeTransaction,int payTransaction) {
		this.codeTransaction = codeTransaction;
		this.timeTransaction = timeTransaction;
		this.payTransaction = payTransaction;
	}

	public String getCodeTransaction() {
		return codeTransaction;
	}

	public void setCodeTransaction(String codeTransaction) {
		this.codeTransaction = codeTransaction;
	}

	public Timestamp getTimeTransaction() {
		return timeTransaction;
	}

	public void setTimeTransaction(Timestamp timeTransaction) {
		this.timeTransaction = timeTransaction;
	}

	public int getPayTransaction() {
		return payTransaction;
	}

	public void setPayTransaction(int payTransaction) {
		this.payTransaction = payTransaction;
	}
	
}
