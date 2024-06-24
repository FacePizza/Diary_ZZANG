package kr.hs.dgsw.Template.Diary.DTO;

import kr.hs.dgsw.Template.Diary.Entity.DiaryEntity;
import kr.hs.dgsw.Template.Forecast.Enum.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DiaryReq {
    private String title;
    private String content;
    private String writer;
    private Weather weather;
    private Integer likes;

    public static DiaryEntity toEntity(DiaryReq req) {
        DiaryEntity _entity = DiaryEntity
                .builder()
                .title(req.getTitle())
                .content(req.getContent())
                .writer(req.getWriter())
                .weather(req.getWeather())
                .likes(req.getLikes())
                .build();

        return _entity;
    }
}

