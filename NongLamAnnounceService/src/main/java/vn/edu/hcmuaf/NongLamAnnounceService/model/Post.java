package vn.edu.hcmuaf.NongLamAnnounceService.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Post {
	private String postId;
	private String id;
	private String title;
	private String content;
	private String classId;
	private Date postDate;
	
	public Post() {
	}
	
	public Post(String postId, String id, String title, String content, String classId, Date postDate) {
		this.postId = postId;
		this.id = id;
		this.title = title;
		this.content = content;
		this.classId = classId;
		this.postDate = postDate;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
}
