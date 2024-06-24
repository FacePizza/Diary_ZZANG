package kr.hs.dgsw.Template.Diary.DTO;

import kr.hs.dgsw.Template.Diary.Entity.DiaryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Integer likes;
    private LocalDateTime regDate, modDate;

    public DiaryEntity toEntity() {
        DiaryEntity _entity = DiaryEntity
                .builder()
                .id(null)
                .title(title)
                .content(content)
                .writer(writer)
                .likes(likes)
                .build();

        return _entity;
    }
}
