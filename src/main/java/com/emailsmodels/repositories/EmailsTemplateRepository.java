package com.emailsmodels.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailsmodels.entities.Category;
import com.emailsmodels.entities.EmailsTemplate;

public interface EmailsTemplateRepository extends JpaRepository<EmailsTemplate, Integer> {

	List<EmailsTemplate> findByCategory_Id(Integer category_Id);

}
