package com.emailsmodels.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class EmailsTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emailstemplate_sequence")
	@SequenceGenerator(name = "emailstemplate_sequence", sequenceName = "emailstemplate_sequence", allocationSize = 1)
	private Integer id;

	@Column(name = "email_assunt")
	private String emailAssunt;

	@Column(name = "body_text")
	private String bodyText;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@JoinColumn(name = "category_id")
	@ManyToOne
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailAssunt() {
		return emailAssunt;
	}

	public void setEmailAssunt(String emailAssunt) {
		this.emailAssunt = emailAssunt;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
