package vn.edu.hcmuaf.NongLamAnnounceService.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InfoGroupOfUser {
	private String id;
	private String class_id;
	private String email;
	private String lname;
	private String fname;
	private String faculty_id;
	
	public InfoGroupOfUser() {
	}

	public InfoGroupOfUser(String id, String class_id, String email, String lname, String fname, String faculty_id) {
		this.id = id;
		this.class_id = class_id;
		this.email = email;
		this.lname = lname;
		this.fname = fname;
		this.faculty_id = faculty_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}
}
