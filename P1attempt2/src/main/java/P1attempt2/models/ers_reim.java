package P1attempt2.models;

import java.sql.Date;

public class ers_reim {
	private int reim_ID;
	public int getReim_ID() {
		return reim_ID;
	}
	public void setReim_ID(int reim_ID) {
		this.reim_ID = reim_ID;
	}
	private double amount;
	private Date time;
	private String desc;
	private int auth;
	private users aut;
	private int res;
	private users respondant;
	private int status;
	private String stat;
	private int type;
	private String types;
	

	public ers_reim(double amount, Date time, String desc, int auth, int res, String stat, String types) {
		super();
		this.amount = amount;
		this.time = time;
		this.desc = desc;
		this.auth = auth;
		this.res = res;
		this.stat = stat;
		this.types = types;
	}
	public ers_reim(double amount, Date time, String desc, users aut, users respondant, String stat, String types) {
		super();
		this.amount = amount;
		this.time = time;
		this.desc = desc;
		this.aut = aut;
		this.respondant = respondant;
		this.stat = stat;
		this.types = types;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
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
	public ers_reim(int reim_ID, double amount, Date time, String desc, users aut, int res, users respondant,
			String stat, String types) {
		super();
		this.reim_ID = reim_ID;
		this.amount = amount;
		this.time = time;
		this.desc = desc;
		this.aut = aut;
		this.res = res;
		this.respondant = respondant;
		this.stat = stat;
		this.types = types;
	}
	public ers_reim(int reim_ID, double amount, Date time, String desc, users aut, users respondant, String stat,
			String types) {
		super();
		this.reim_ID = reim_ID;
		this.amount = amount;
		this.time = time;
		this.desc = desc;
		this.aut = aut;
		this.respondant = respondant;
		this.stat = stat;
		this.types = types;
	}


}
