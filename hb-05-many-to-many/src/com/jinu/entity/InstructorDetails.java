package com.jinu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetails {
	
	@OneToOne(mappedBy="instructorDetails",cascade=CascadeType.ALL)
    private Instructor insstructor;
    
	public Instructor getInsstructor() {
		return insstructor;
	}
	public void setInsstructor(Instructor insstructor) {
		this.insstructor = insstructor;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="youtube_channel")
	private String youtubechannel;
	@Column(name="hobby")
	private String hobby;
	public InstructorDetails() {
		super();
	}
	public InstructorDetails(String youtubechannel, String hobby) {
		this.youtubechannel = youtubechannel;
		this.hobby = hobby;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYoutubechannel() {
		return youtubechannel;
	}
	public void setYoutubechannel(String youtubechannel) {
		this.youtubechannel = youtubechannel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", youtubechannel="
				+ youtubechannel + ", hobby=" + hobby + "]";
	}
	

}
