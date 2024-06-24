package kr.hs.dgsw.Template.Diary.Repository.query;

import kr.hs.dgsw.Template.Diary.DTO.DiaryResponse;

import java.util.List;

public interface DiaryQueryRepository {
    List<DiaryResponse> findDiaryList();
}
