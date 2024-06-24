package kr.hs.dgsw.Template.Comment.Service;

import kr.hs.dgsw.Template.Diary.Repository.DiaryRepository;
import kr.hs.dgsw.Template.Comment.DTO.CommentDTO;
import kr.hs.dgsw.Template.Comment.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final DiaryRepository diaryRepository;

    @Override
    public Long register(CommentDTO dto) {
        if(diaryRepository.existsById(dto.getDiaryId())){
            return commentRepository.save(CommentDTO.toEntity(dto)).getId();
        }
        else{
            throw new RuntimeException("diary not found");
        }
    }

    @Override
    public void delete(Long id) {
        if(commentRepository.existsById(id)){
            commentRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("comment not found");
        }
    }

}
