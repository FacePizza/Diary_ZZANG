package kr.hs.dgsw.Template.Comment.Service;

import kr.hs.dgsw.Template.Comment.DTO.CommentDTO;

public interface CommentService {
    Long register(CommentDTO dto);
    void delete(Long id);
}
