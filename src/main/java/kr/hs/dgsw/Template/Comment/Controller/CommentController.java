package kr.hs.dgsw.Template.Comment.Controller;

import kr.hs.dgsw.Template.Comment.DTO.CommentDTO;
import kr.hs.dgsw.Template.Comment.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Long register(@RequestBody CommentDTO dto){
        return commentService.register(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }

}
