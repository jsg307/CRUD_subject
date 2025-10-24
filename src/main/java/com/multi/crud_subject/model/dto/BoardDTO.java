package com.multi.crud_subject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private int no;
    private int categoryCode;
    private String title;
    private String content;
    private String writer;
    private String writerName;
    private int count;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String status;

    private CategoryDTO category;


}
