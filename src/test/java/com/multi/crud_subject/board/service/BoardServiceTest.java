package com.multi.crud_subject.board.service;

import com.multi.crud_subject.board.model.dao.BoardMapper;
import com.multi.crud_subject.board.model.dto.BoardDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    @Mock
    private BoardMapper boardMapper;

    @InjectMocks
    private BoardService service;

    @Test
    @DisplayName("전체 게시글 조회 테스트")
    void selectAllBoard() {
        //given
        List<BoardDTO> mockList = Arrays.asList(
                BoardDTO.builder().no(1).title("자바").content("자바입니다").build(),
                BoardDTO.builder().no(2).title("스프링부트").content("스프링부트입니다").build(),
                BoardDTO.builder().no(3).title("JSP").content("JSP입니다").build()
        );
        when(boardMapper.selectAllBoard()).thenReturn(mockList);
        //when
        List<BoardDTO> result = service.selectAllBoard();

        //then
        assertThat(result).isNotNull().hasSize(3);
        result.stream().forEach(System.out::println);

    }

    @Test
    @DisplayName("게시글 상세 조회 테스트")
    void selectBoardByNo() {
        //given
        BoardDTO selectOneMock = BoardDTO.builder()
                .no(1).title("자바").content("자바입니다").build();
        when(boardMapper.selectBoardByNo(1)).thenReturn(selectOneMock);
        //when
        BoardDTO result = service.selectBoardByNo(1);
        //then
        assertThat(result).isNotNull().isEqualTo(selectOneMock);
        System.out.println(result);
    }

    @Test
    @DisplayName("게시글 작성 테스트")
    void insertBoard() {

        //given
        BoardDTO boardDTO = BoardDTO.builder().no(3).title("자전거").content("따르릉 따르릉").writer(3).build();
        when(boardMapper.insertBoard(boardDTO)).thenReturn(1);

        //when
        int result = service.insertBoard(boardDTO);

        //then
        assertThat(result).isEqualTo(1);
    }


    @Test
    @DisplayName("게시글 수정 테스트")
    void updateBoard() {

        //given
        BoardDTO boardDTO = BoardDTO.builder().no(3).title("오토바이").content("부릉 부릉").writer(3).build();
        when(boardMapper.updateBoard(boardDTO)).thenReturn(1);

        //when
        int result = service.updateBoard(boardDTO);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void deleteBoard() {

        //given
        BoardDTO boardDTO = BoardDTO.builder().no(3).title("오토바이").content("부릉 부릉").writer(3).build();
        when(boardMapper.deleteBoard(3)).thenReturn(1);
        //when
        int result = service.deleteBoard(3);
        //then
        assertThat(result).isEqualTo(1);
    }
}