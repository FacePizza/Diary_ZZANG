package kr.hs.dgsw.Template.Diary.Entity;

import jakarta.persistence.*;
import kr.hs.dgsw.Template.Diary.DTO.DiaryDTO;
import kr.hs.dgsw.Template.Forecast.Enum.Weather;
import kr.hs.dgsw.Template.Shared.Entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "diary_tbl" )
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DiaryEntity extends BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long id;

    @Column( length = 100, nullable = false )
    private String title;

    @Column( length = 2000, nullable = false )
    private String content;

    @Column( length = 50, nullable = false )
    private String writer;

    @Column( length = 100, nullable = false )
    private Weather weather;

    @Column( nullable = false )
    private Integer likes;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public DiaryDTO toDTO() {
        DiaryDTO _dto = DiaryDTO
                .builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .weather(weather)
                .likes(likes)
                .regDate(getRegDate())
                .modDate(getModDate())
                .build();

        return _dto;
    }

}
