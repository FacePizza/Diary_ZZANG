package kr.hs.dgsw.Template.comment.controller;

import kr.hs.dgsw.Template.comment.dto.CommentDTO;
import kr.hs.dgsw.Template.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void register(CommentDTO dto){
        commentService.register(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }

}
