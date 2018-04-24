package vn.edu.hcmuaf.NongLamAnnounceService.model;

import java.sql.Date;

public class Post {
private String id;
private String title;
private String content;
private String classID;
private Date datePost;

public Post(String id, String title, String content, String classID, Date datePost) {
	this.id = id;
	this.title = title;
	this.content = content;
	this.classID = classID;
	this.datePost = datePost;
}
public String getId() {
	return id;
}
public String getTitle() {
	return title;
}
public String getContent() {
	return content;
}
public String getClassID() {
	return classID;
}
public Date getDatePost() {
	return datePost;
}
public void setId(String id) {
	this.id = id;
}
public void setTitle(String title) {
	this.title = title;
}
public void setContent(String content) {
	this.content = content;
}
public void setClassID(String classID) {
	this.classID = classID;
}
public void setDatePost(Date datePost) {
	this.datePost = datePost;
}

}
