package vn.edu.hcmuaf.NongLamAnnounceService.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Announce {
	private String postId;
	private String id;
	private String title;
	private String content;
	private String class_id;
	private String date;
	private String url_img;
	
	public Announce() {
	}
	
	public Announce(String postId, String id, String title, String content, String classId, String date, String url_img) {
		this.postId = postId;
		this.id = id;
		this.title = title;
		this.content = content;
		this.class_id = classId;
		this.date = date;
		this.url_img = url_img;
	}
	
	public Announce(String id, String title, String content, String classId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.class_id = classId;
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
		return class_id;
	}

	public void setClassId(String classId) {
		this.class_id = classId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl_img() {
		return url_img;
	}

	public void setUrl_img(String url_img) {
		this.url_img = url_img;
	}
}
