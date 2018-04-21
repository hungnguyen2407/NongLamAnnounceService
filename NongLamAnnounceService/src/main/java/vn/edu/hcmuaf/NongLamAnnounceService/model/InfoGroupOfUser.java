package vn.edu.hcmuaf.NongLamAnnounceService.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InfoGroupOfUser {
	private String id;
	private String class_id;
	private String class_name;
	private String faculty_id;
	private int number;
	
	public InfoGroupOfUser() {
	}

	public InfoGroupOfUser(String id, String class_id, String class_name, String faculty_id, int number) {
		super();
		this.id = id;
		this.class_id = class_id;
		this.class_name = class_name;
		this.faculty_id = faculty_id;
		this.number = number;
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

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
