package kr.hs.dgsw.Template.Diary.Repository;

import kr.hs.dgsw.Template.Diary.Entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {
}
