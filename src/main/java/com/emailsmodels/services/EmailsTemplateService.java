package com.emailsmodels.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emailsmodels.dto.EmailsTemplateDTO;
import com.emailsmodels.entities.Category;
import com.emailsmodels.entities.EmailsTemplate;
import com.emailsmodels.repositories.CategoryRepository;
import com.emailsmodels.repositories.EmailsTemplateRepository;

@Service
public class EmailsTemplateService {

	private final EmailsTemplateRepository emailsTemplateRepository;
	private final CategoryRepository categoryRepository;

	public EmailsTemplateService(EmailsTemplateRepository emailsTemplateRepository,
			CategoryRepository categoryRepository) {
		this.emailsTemplateRepository = emailsTemplateRepository;
		this.categoryRepository = categoryRepository;
	}

	public void validEmailsTemplate(EmailsTemplateDTO emailsTemplateDTO) {

		String bodyText = emailsTemplateDTO.getBodyText();
		String assuntEmail = emailsTemplateDTO.getEmailAssunt();
		Integer category = emailsTemplateDTO.getCategory();

		if (emailsTemplateDTO.getBodyText() == null || emailsTemplateDTO.getCategory() == null
				|| emailsTemplateDTO.getEmailAssunt() == null) {

			if (bodyText == null || bodyText.isBlank()) {
				throw new IllegalArgumentException("BodyText not can be null ");
			}

			if (assuntEmail == null || assuntEmail.isBlank()) {
				throw new IllegalArgumentException(" AssuntEmail not can be null ");
			}

			if (category == null) {
				throw new IllegalArgumentException("Category not can be null ");
			}

		}

	}

	public Category categoryValid(EmailsTemplateDTO emailsTemplateDTO) {
		return categoryRepository.findById(emailsTemplateDTO.getCategory())
				.orElseThrow(() -> new IllegalArgumentException("Category is not found"));
	}

	public void saveEmails(EmailsTemplateDTO emailsTemplateDTO) {

		validEmailsTemplate(emailsTemplateDTO);
		categoryValid(emailsTemplateDTO);

		EmailsTemplate emailsTemplate = new EmailsTemplate();
		emailsTemplate.setEmailAssunt(emailsTemplateDTO.getEmailAssunt());
		emailsTemplate.setBodyText(emailsTemplateDTO.getBodyText());
		emailsTemplate.setCreatedAt(LocalDateTime.now());
		emailsTemplate.setUpdatedAt(LocalDateTime.now());
		emailsTemplate.setCategory(categoryValid(emailsTemplateDTO));
		emailsTemplateRepository.save(emailsTemplate);

	}

	public void updateEmails(EmailsTemplateDTO emailsTemplateDTO, Integer id) {

		EmailsTemplate emailsTemplate = emailsTemplateRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Email template not found"));

		Category category = categoryValid(emailsTemplateDTO);

		if (emailsTemplateDTO.getEmailAssunt() != null) {
			emailsTemplate.setEmailAssunt(emailsTemplateDTO.getEmailAssunt());
		}

		if (emailsTemplateDTO.getBodyText() != null) {
			emailsTemplate.setBodyText(emailsTemplateDTO.getBodyText());
		}

		if (category.getId() != null) {
			emailsTemplate.setCategory(category);
		}

		emailsTemplate.setUpdatedAt(LocalDateTime.now());

		emailsTemplateRepository.save(emailsTemplate);

	}

	public EmailsTemplateDTO getEmailsById(Integer id) {
		EmailsTemplate emailsTemplate = emailsTemplateRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Email template not found"));
		EmailsTemplateDTO emailsTemplateDTO = new EmailsTemplateDTO();

		emailsTemplateDTO.setId(id);
		emailsTemplateDTO.setEmailAssunt(emailsTemplate.getEmailAssunt());
		emailsTemplateDTO.setBodyText(emailsTemplate.getBodyText());
		emailsTemplateDTO.setCreatedAt(emailsTemplate.getCreatedAt());
		emailsTemplateDTO.setUpdatedAt(emailsTemplate.getUpdatedAt());
		emailsTemplateDTO.setCategory(emailsTemplate.getCategory().getId());

		return emailsTemplateDTO;
	}

	public List<EmailsTemplateDTO> getTemplatesByCategory(Integer categoryId) {

		List<EmailsTemplate> emailsTemplateByCategory = emailsTemplateRepository.findByCategory_Id(categoryId);
		List<EmailsTemplateDTO> emailsTemplateListByCategory = new ArrayList<>();

		for (EmailsTemplate emailsByCategory : emailsTemplateByCategory) {
			EmailsTemplateDTO emailsTemplateDTO = new EmailsTemplateDTO();
			emailsTemplateDTO.setId(emailsByCategory.getId());
			emailsTemplateDTO.setEmailAssunt(emailsByCategory.getEmailAssunt());
			emailsTemplateDTO.setBodyText(emailsByCategory.getBodyText());
			emailsTemplateDTO.setCreatedAt(emailsByCategory.getCreatedAt());
			emailsTemplateDTO.setUpdatedAt(emailsByCategory.getUpdatedAt());
			emailsTemplateDTO.setCategory(emailsByCategory.getCategory().getId());
			emailsTemplateListByCategory.add(emailsTemplateDTO);
		}
		return emailsTemplateListByCategory;

	}

	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}

}
