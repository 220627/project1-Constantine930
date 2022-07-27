package P1attempt2.models;

public class users {
	private String name;
	private String pass;
	private String fname;
	private String lname;
	private String email;
	private int perm;
	private int ID;



	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPerm() {
		return perm;
	}
	public void setPerm(int perm) {
		this.perm = perm;
	}
	@Override
	public String toString() {
		return "users [fname=" + fname + ", lname=" + lname + ", perm=" + perm + ", id="+ ID + "]";
	}

	public users(String name, String pass, String fname, String lname, String email, int perm) {
		super();
		this.name = name;
		this.pass = pass;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.perm = perm;
	}
	public users(String name, String fname, String lname, String email, int perm) {
		super();
		this.name = name;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.perm = perm;
	}
	public users(String fname, String lname, String email, int perm,int ID) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.perm = perm;
		this.ID= ID;
	}


}
