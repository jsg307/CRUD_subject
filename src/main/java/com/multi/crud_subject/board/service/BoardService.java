package com.multi.crud_subject.board.service;

import com.multi.crud_subject.board.model.dao.BoardMapper;
import com.multi.crud_subject.board.model.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardDTO> selectAllBoard() {
        return boardMapper.selectAllBoard();
    }

    public BoardDTO selectBoardByNo(int no) {
        return boardMapper.selectBoardByNo(no);

    }

    public int insertBoard(BoardDTO boardDTO) {

        return boardMapper.insertBoard(boardDTO);
    }

    public int updateBoard(BoardDTO boardDTO) {

        return boardMapper.updateBoard(boardDTO);

    }

    public int deleteBoard(int no) {

        return boardMapper.deleteBoard(no);

    }
}
