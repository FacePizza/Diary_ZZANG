package kr.hs.dgsw.Template.Diary.Repository.query;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.hs.dgsw.Template.Diary.DTO.DiaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.hs.dgsw.Template.Diary.Entity.QDiaryEntity.diaryEntity;
import static kr.hs.dgsw.Template.comment.entity.QCommentEntity.commentEntity;

@RequiredArgsConstructor
@Repository
public class DiaryQueryRepositoryImpl implements DiaryQueryRepository{

    private JPAQueryFactory queryFactory;

    @Override
    public List<DiaryResponse> findDiaryList() {
        return queryFactory.select(diaryConstructor())
                .from(commentEntity)
                .leftJoin(diaryEntity)
                .on(commentEntity.diaryId.eq(diaryEntity.id))
                .fetchJoin()
                .orderBy(diaryEntity.id.asc())
                .fetch();
    }

    private ConstructorExpression<DiaryResponse> diaryConstructor(){
        return Projections.constructor(
                DiaryResponse.class,
                diaryEntity.id,
                diaryEntity.title,
                diaryEntity.content,
                diaryEntity.writer,
                diaryEntity.weather,
                diaryEntity.likes,
                diaryEntity.regDate,
                diaryEntity.modDate,
                commentEntity.id,
                commentEntity.comment
        );
    }
}
