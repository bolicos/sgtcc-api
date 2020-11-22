package com.analuciabolico.sgtccapi.v1.boards.services.interfaces;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.analuciabolico.sgtccapi.v1.boards.dtos.BoardRequest;
import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;

public interface IBoardService {

    ResourceCreated save(BoardRequest boardRequest);

    Board findById(Long id);

    List<Board> findAll(Sort sort);
}
