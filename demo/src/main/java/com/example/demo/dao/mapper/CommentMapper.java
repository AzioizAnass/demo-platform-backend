package com.example.demo.dao.mapper;
import com.example.demo.dao.domain.Comment;
import com.example.demo.dao.dto.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface CommentMapper {
    @Mapping(target = "article",source="article",ignore = true )
    CommentDto CommentToCommentDTO (Comment cmnt);
    Comment  CommentDTOToComment (CommentDto cmnt);
    @Mapping(target = "article",source="article",ignore = true )
    Comment upDateCommentFromDto(CommentDto cmntDTO , @MappingTarget Comment cmnt);
    @Mapping(target = "article",source="article",ignore = true )
    List<CommentDto> mapToComments(List<Comment> commentEntityList);
}
