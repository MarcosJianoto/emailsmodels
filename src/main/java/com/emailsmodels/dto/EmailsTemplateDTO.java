package com.emailsmodels.dto;

import java.time.LocalDateTime;

public class EmailsTemplateDTO {

	private Integer id;

	private String emailAssunt;

	private String bodyText;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private Integer category;

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

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

}
