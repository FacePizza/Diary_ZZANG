package kr.hs.dgsw.Template.Diary.DTO;

import kr.hs.dgsw.Template.Diary.Entity.DiaryEntity;
import kr.hs.dgsw.Template.Forecast.Enum.Weather;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDTO {
    private Long id = null;
    private String title;
    private String content;
    private String writer;
    private Weather weather;
    private Integer likes;
    private LocalDateTime regDate, modDate = null;


    public DiaryEntity toEntity() {
        DiaryEntity _entity = DiaryEntity
                .builder()
                .id(null)
                .title(title)
                .content(content)
                .writer(writer)
                .weather(weather)
                .likes(likes)
                .build();

        return _entity;
    }
}
