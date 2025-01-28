package com.emailsmodels.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailsmodels.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
