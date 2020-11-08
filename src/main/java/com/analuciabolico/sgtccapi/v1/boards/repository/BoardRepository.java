package com.analuciabolico.sgtccapi.v1.boards.repository;

import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
