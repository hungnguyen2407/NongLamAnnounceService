package vn.edu.hcmuaf.NongLamAnnounceService.model;

import java.util.List;

public class ListClass {
private String id;
private List<String> listClassID;
private List<String> listClassName;
public ListClass() {
}
public String getId() {
	return id;
}
public List<String> getListClassID() {
	return listClassID;
}
public List<String> getListClassName() {
	return listClassName;
}
public void setId(String id) {
	this.id = id;
}
public void setListClassID(List<String> listClassID) {
	this.listClassID = listClassID;
}
public void setListClassName(List<String> listClassName) {
	this.listClassName = listClassName;
}

}
