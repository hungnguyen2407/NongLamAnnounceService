package vn.edu.hcmuaf.NongLamAnnounceService.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InformationUser {
	private String id;
	private String email;
	private String fName;
	private String lName;
	private String birthday;
	private String faculty_id;
	private String class_id;
	private String pass;
	private String url_avatar;
	private byte level;

	public InformationUser() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getFacultyID() {
		return faculty_id;
	}

	public void setFacultyID(String facultyID) {
		this.faculty_id = facultyID;
	}

	public String getClassID() {
		return class_id;
	}

	public void setClassID(String classID) {
		this.class_id = classID;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUrl_avatar() {
		return url_avatar;
	}

	public void setUrl_avatar(String url_avatar) {
		this.url_avatar = url_avatar;
	}

}
