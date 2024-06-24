package kr.hs.dgsw.Template.comment.service;

import kr.hs.dgsw.Template.comment.dto.CommentDTO;

public interface CommentService {
    void register(CommentDTO dto);
    void delete(Long id);
}
