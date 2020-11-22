package com.analuciabolico.sgtccapi.v1.titles.repository;

import com.analuciabolico.sgtccapi.v1.titles.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
}
