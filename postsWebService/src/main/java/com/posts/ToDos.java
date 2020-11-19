package com.posts;

public class ToDos {
	private int id;
	private String title;
	private String completed;
	public ToDos() {
	}
	public ToDos(int id, String title, String completed) {
		this.id = id;
		this.title = title;
		this.completed = completed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "ToDos [id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}
}
