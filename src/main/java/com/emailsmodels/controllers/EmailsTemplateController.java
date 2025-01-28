package com.emailsmodels.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emailsmodels.dto.EmailsTemplateDTO;
import com.emailsmodels.services.EmailsTemplateService;

@RestController
public class EmailsTemplateController {

	private final EmailsTemplateService emailsTemplateService;

	public EmailsTemplateController(EmailsTemplateService emailsTemplateService) {
		this.emailsTemplateService = emailsTemplateService;
	}

	@PostMapping("/saveemailtemplate")
	public ResponseEntity<Void> saveCategory(@RequestBody EmailsTemplateDTO emailsTemplateDTO) {

		emailsTemplateService.saveEmails(emailsTemplateDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/updateemailtemplate/{id}")
	public ResponseEntity<Void> updateCategory(@RequestBody EmailsTemplateDTO emailsTemplateDTO,
			@PathVariable Integer id) {

		emailsTemplateService.updateEmails(emailsTemplateDTO, id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getemailtempatebyid/{id}")
	public ResponseEntity<EmailsTemplateDTO> getEmailForId(@PathVariable Integer id) {
		EmailsTemplateDTO emailsTemplateDTO = emailsTemplateService.getEmailsById(id);
		return ResponseEntity.ok().body(emailsTemplateDTO);
	}

	@GetMapping("/getemailstempatebycategory/{categoryId}")
	public ResponseEntity<List<EmailsTemplateDTO>> getEmailForCategoryId(@PathVariable Integer categoryId) {
		List<EmailsTemplateDTO> emailsTemplateDTO = emailsTemplateService.getTemplatesByCategory(categoryId);
		return ResponseEntity.ok().body(emailsTemplateDTO);
	}

	@DeleteMapping("/deleteemailtemplate/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		emailsTemplateService.deleteCategory(id);
	}
}
