package com.analuciabolico.sgtccapi.v1.boards.services.implementations;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.boards.dtos.BoardRequest;
import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import com.analuciabolico.sgtccapi.v1.boards.repository.BoardRepository;
import com.analuciabolico.sgtccapi.v1.boards.services.interfaces.IBoardService;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;

import lombok.AllArgsConstructor;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class BoardService implements IBoardService {
    private final BoardRepository boardRepository;

    @Override
    public ResourceCreated save(BoardRequest boardRequest) {
        return new ResourceCreated(boardRepository.save(boardRequest.convertToBoard()).getId());
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Board> findAll(Sort sort) {
        return boardRepository.findAll(sort);
    }
}
