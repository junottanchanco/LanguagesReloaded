package com.codingdojo.crud.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Language {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=5, max=200)
	private String name;
	
	@Column
	@Size(min=5, max=200)
	private String creator;
	
	@Column
	@Min(1)
	private int currentVersion;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyy HH:mm;ss")
	private Date created_at;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyy HH:mm;ss")
	private Date updated_at;
	
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
	
	public Language() {
	}
	
	public Language(String name, String creator, int version) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = version;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(int currentVersion) {
		this.currentVersion = currentVersion;
	}
}
	