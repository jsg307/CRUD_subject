package com.multi.crud_subject.board.model.dao;

import com.multi.crud_subject.board.model.dto.BoardDTO;
import com.multi.crud_subject.board.model.dto.CategoryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void 매퍼_인터페이스_의존성주입테스트(){
        assertNotNull(boardMapper);
        assertThat(boardMapper).isNotNull();
    }

    @Test
    void selectAllBoard() {

        //given
        //when
        List<BoardDTO> list = boardMapper.selectAllBoard();
        //then
        assertThat(list).isNotNull();

        list.stream().forEach(System.out::println);

    }

    @Test
    @Transactional
    void selectBoardByNo() {
        //given
        int no = 1;
        //when
        BoardDTO boardDTO = boardMapper.selectBoardByNo(no);
        //then
        assertThat(boardDTO).isNotNull();
    }

    @Test
    @Transactional
    void insertBoard() {

        //given
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCCode(1);

        BoardDTO board = BoardDTO.builder()
                .categoryCode(categoryDTO.getCCode())
                .title("스프링부트")
                .content("이번에는 스프링 부트다")
                .writer(1)
                .build();
        //when
        int result = boardMapper.insertBoard(board);

        //then
        assertEquals(1,result);
        assertThat(result).isEqualTo(1);
        System.out.println(result);

    }

    @Test
    @Transactional
    void updateBoard() {

        //given
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCCode(10);

        BoardDTO board = BoardDTO.builder()
                .no(1)
                .categoryCode(categoryDTO.getCCode())
                .title("(수정)스프링부트")
                .content("이번에는 스프링 부트 수정이다")
                .writer(1)
                .build();

        //when
        int result = boardMapper.updateBoard(board);

        //then
        assertEquals(1,result);
        assertThat(result).isEqualTo(1);

    }

    @Test
    @Transactional
    void deleteBoard() {
        //given
        int no = 1;
        //when
        int result = boardMapper.deleteBoard(no);
        //then
        assertEquals(1,result);
        assertThat(result).isEqualTo(1);
    }
}