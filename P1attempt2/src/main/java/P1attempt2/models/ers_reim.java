package P1attempt2.models;

import java.sql.Date;

public class ers_reim {
	private double amount;
	private Date time;
	private String desc;
	private int auth;
	private users aut;
	private int res;
	private users respondant;
	private int status;
	private int type;

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ers_reim(double amount, Date time, String desc, int auth, int res, int status, int type) {
		super();
		this.amount = amount;
		this.time = time;
		this.desc = desc;
		this.auth = auth;
		this.res = res;
		this.status = status;
		this.type = type;
	}
	
	public ers_reim(double amount, Date time, String desc, users aut, users respondant, int status, int type) {
		super();
		this.amount = amount;
		this.time = time;
		this.desc = desc;
		this.aut = aut;
		this.respondant = respondant;
		this.status = status;
		this.type = type;
	}
	public users getAut() {
		return aut;
	}
	public void setAut(users aut) {
		this.aut = aut;
	}
	public users getRespondant() {
		return respondant;
	}
	public void setRespondant(users respondant) {
		this.respondant = respondant;
	}
	@Override
	public String toString() {
		return "ers_reim [amount=" + amount + ", time=" + time + ", desc=" + desc + ", status=" + status + ", type=" + type + "]";
	}
}
