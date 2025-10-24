package com.multi.crud_subject.board.model.dao;

import com.multi.crud_subject.board.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> selectAllBoard();
    BoardDTO selectBoardByNo(@Param("no") int no);
    int insertBoard(BoardDTO board);
    int updateBoard(BoardDTO board);
    int deleteBoard(@Param("no") int no);

}
