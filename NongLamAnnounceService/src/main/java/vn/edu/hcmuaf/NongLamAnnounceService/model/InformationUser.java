package vn.edu.hcmuaf.NongLamAnnounceService.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InformationUser {
	private String id;
	private String email;
	private String fName;
	private String lName;
	private String birthday;
	private String facultyID;
	private String classID;
	private String pass;
	private String url_avatar;
	private int level;

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
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
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
