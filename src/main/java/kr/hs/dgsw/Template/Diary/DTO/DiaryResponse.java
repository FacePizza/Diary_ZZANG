package kr.hs.dgsw.Template.Diary.DTO;

import kr.hs.dgsw.Template.Forecast.Enum.Weather;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaryResponse {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Weather weather;
    private Integer likes;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private Long commentId;
    private String comment;
}
