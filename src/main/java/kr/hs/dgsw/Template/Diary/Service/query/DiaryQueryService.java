package kr.hs.dgsw.Template.Diary.Service.query;

import kr.hs.dgsw.Template.Diary.DTO.DiaryResponse;

import java.util.List;

public interface DiaryQueryService {
    List<DiaryResponse> findDiaryList();
}
