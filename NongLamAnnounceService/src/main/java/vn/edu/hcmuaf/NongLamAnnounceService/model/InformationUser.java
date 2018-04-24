package vn.edu.hcmuaf.NongLamAnnounceService.model;

public class InformationUser {
private String id;
private String email;
private String fName;
private String lName;
private String facultyID;
private String classID;
public InformationUser() {
}
public String getId() {
	return id;
}
public String getEmail() {
	return email;
}
public String getfName() {
	return fName;
}
public String getlName() {
	return lName;
}
public String getFacultyID() {
	return facultyID;
}
public String getClassID() {
	return classID;
}
public void setId(String id) {
	this.id = id;
}
public void setEmail(String email) {
	this.email = email;
}
public void setfName(String fName) {
	this.fName = fName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public void setFacultyID(String facultyID) {
	this.facultyID = facultyID;
}
public void setClassID(String classID) {
	this.classID = classID;
}

}
