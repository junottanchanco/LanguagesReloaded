package com.codingdojo.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.crud.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
}
