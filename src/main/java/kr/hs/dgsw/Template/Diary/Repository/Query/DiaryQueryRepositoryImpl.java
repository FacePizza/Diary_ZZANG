package kr.hs.dgsw.Template.Diary.Repository.Query;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.hs.dgsw.Template.Diary.DTO.DiaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.hs.dgsw.Template.Diary.Entity.QDiaryEntity.diaryEntity;
import static kr.hs.dgsw.Template.Comment.Entity.QCommentEntity.commentEntity;

@RequiredArgsConstructor
@Repository
public class DiaryQueryRepositoryImpl implements DiaryQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public DiaryResponse getDiaryById(Long id) {
        return queryFactory.select(diaryConstructor())
                .from(diaryEntity)
                .where(diaryEntity.id.eq(id))
                .fetchOne();
    }

    @Override
    public List<DiaryResponse> findDiaryList() {
        return queryFactory.select(diaryConstructor())
                .from(diaryEntity)
                .leftJoin(commentEntity)
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
