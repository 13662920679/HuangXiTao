package com.huang.pojo;

public class Teacher {
	
	private String tid;
	private String tname;
	private String tsex;
	private int ttype;
	private String tphone;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public int getTtype() {
		return ttype;
	}
	public void setTtype(int ttype) {
		this.ttype = ttype;
	}
	public String getTphone() {
		return tphone;
	}
	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + ((tphone == null) ? 0 : tphone.hashCode());
		result = prime * result + ((tsex == null) ? 0 : tsex.hashCode());
		result = prime * result + ttype;
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
		Teacher other = (Teacher) obj;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (tphone == null) {
			if (other.tphone != null)
				return false;
		} else if (!tphone.equals(other.tphone))
			return false;
		if (tsex == null) {
			if (other.tsex != null)
				return false;
		} else if (!tsex.equals(other.tsex))
			return false;
		if (ttype != other.ttype)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tsex=" + tsex + ", ttype=" + ttype + ", tphone=" + tphone
				+ "]";
	}
	public Teacher(String tid, String tname, String tsex, int ttype, String tphone) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tsex = tsex;
		this.ttype = ttype;
		this.tphone = tphone;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
