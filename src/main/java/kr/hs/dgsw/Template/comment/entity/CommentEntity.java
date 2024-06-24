package kr.hs.dgsw.Template.comment.entity;

import jakarta.persistence.*;
import kr.hs.dgsw.Template.Shared.Entity.BaseEntity;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "comment_tbl")
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long diaryId;

    @Column(nullable = false, length = 100)
    private String comment;

}
