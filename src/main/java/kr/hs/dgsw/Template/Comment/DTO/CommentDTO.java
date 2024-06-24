package kr.hs.dgsw.Template.Comment.DTO;

import kr.hs.dgsw.Template.Comment.Entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CommentDTO {
    private Long diaryId;
    private String comment;

    public static CommentEntity toEntity(CommentDTO dto){
        return CommentEntity.builder()
                .diaryId(dto.diaryId)
                .comment(dto.comment)
                .build();
    }

}
