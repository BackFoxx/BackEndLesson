package com.example.vueBackEnd.dto;

import com.example.vueBackEnd.entity.Content;
import lombok.Setter;

@Setter
public class FindCommentResponseDto {
    private Content content;
    private String userName;
}
