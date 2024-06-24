package kr.hs.dgsw.Template.Diary.Service.Query;

import kr.hs.dgsw.Template.Diary.DTO.DiaryResponse;

import java.util.List;

public interface DiaryQueryService {
    DiaryResponse findDiaryById(Long id);
    List<DiaryResponse> findDiaryList();
}
