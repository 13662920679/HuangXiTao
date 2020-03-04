package com.huang.pojo;

public class Student {
	
	private String sid;
	private String sname;
	private String ssex;
	private String sbirth;
	private String sclass;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSbirth() {
		return sbirth;
	}
	public void setSbirth(String sbirth) {
		this.sbirth = sbirth;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sbirth == null) ? 0 : sbirth.hashCode());
		result = prime * result + ((sclass == null) ? 0 : sclass.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((ssex == null) ? 0 : ssex.hashCode());
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
		Student other = (Student) obj;
		if (sbirth == null) {
			if (other.sbirth != null)
				return false;
		} else if (!sbirth.equals(other.sbirth))
			return false;
		if (sclass == null) {
			if (other.sclass != null)
				return false;
		} else if (!sclass.equals(other.sclass))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (ssex == null) {
			if (other.ssex != null)
				return false;
		} else if (!ssex.equals(other.ssex))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", ssex=" + ssex + ", sbirth=" + sbirth + ", sclass="
				+ sclass + "]";
	}
	public Student(String sid, String sname, String ssex, String sbirth, String sclass) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.ssex = ssex;
		this.sbirth = sbirth;
		this.sclass = sclass;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

}
