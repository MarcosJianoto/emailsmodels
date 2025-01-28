package com.emailsmodels.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailsmodels.entities.Category;
import com.emailsmodels.entities.EmailsTemplate;

public interface EmailsTemplateRepository extends JpaRepository<EmailsTemplate, Integer> {

}
