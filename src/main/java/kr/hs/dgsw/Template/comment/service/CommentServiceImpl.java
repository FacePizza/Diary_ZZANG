package kr.hs.dgsw.Template.comment.service;

import kr.hs.dgsw.Template.Diary.Repository.DiaryRepository;
import kr.hs.dgsw.Template.comment.dto.CommentDTO;
import kr.hs.dgsw.Template.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final DiaryRepository diaryRepository;

    @Override
    public void register(CommentDTO dto) {
        if(diaryRepository.existsById(dto.getDiaryId())){
            commentRepository.save(CommentDTO.toEntity(dto));
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
