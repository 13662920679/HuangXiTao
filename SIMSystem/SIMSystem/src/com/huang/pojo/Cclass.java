package com.huang.pojo;

public class Cclass {
	
	private String cid;
	private String cname;
	private String ctJava;
	private String ctPython;
	private String ctC;
	private int num;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtJava() {
		return ctJava;
	}
	public void setCtJava(String ctJava) {
		this.ctJava = ctJava;
	}
	public String getCtPython() {
		return ctPython;
	}
	public void setCtPython(String ctPython) {
		this.ctPython = ctPython;
	}
	public String getCtC() {
		return ctC;
	}
	public void setCtC(String ctC) {
		this.ctC = ctC;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((ctC == null) ? 0 : ctC.hashCode());
		result = prime * result + ((ctJava == null) ? 0 : ctJava.hashCode());
		result = prime * result + ((ctPython == null) ? 0 : ctPython.hashCode());
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cclass other = (Cclass) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (ctC == null) {
			if (other.ctC != null)
				return false;
		} else if (!ctC.equals(other.ctC))
			return false;
		if (ctJava == null) {
			if (other.ctJava != null)
				return false;
		} else if (!ctJava.equals(other.ctJava))
			return false;
		if (ctPython == null) {
			if (other.ctPython != null)
				return false;
		} else if (!ctPython.equals(other.ctPython))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cclass [cid=" + cid + ", cname=" + cname + ", ctJava=" + ctJava + ", ctPython=" + ctPython + ", ctC="
				+ ctC + ", num=" + num + "]";
	}
	public Cclass(String cid, String cname, String ctJava, String ctPython, String ctC, int num) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ctJava = ctJava;
		this.ctPython = ctPython;
		this.ctC = ctC;
		this.num = num;
	}
	public Cclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
