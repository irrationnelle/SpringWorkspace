package ex01_account.vo;

public class AccountVO {
	private int accountNum;
	private String name;
	private int amount;
	private String password;
	
	public AccountVO() {	}

	public AccountVO(int accountNum, String name, int amount, String password) {
		this.accountNum = accountNum;
		this.name = name;
		this.amount = amount;
		this.password = password;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AccountVO [accountNum=" + accountNum + ", name=" + name + ", amount=" + amount + ", password="
				+ password + "]";
	}
}
