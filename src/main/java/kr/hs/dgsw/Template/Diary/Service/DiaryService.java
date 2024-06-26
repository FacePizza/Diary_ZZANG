package kr.hs.dgsw.Template.Diary.Service;

import kr.hs.dgsw.Template.Diary.DTO.DiaryDTO;
import kr.hs.dgsw.Template.Diary.DTO.DiaryReq;

import java.util.List;

public interface DiaryService {
    Long register(DiaryReq req);
    List<DiaryDTO> getList();
    DiaryDTO get(Long id);
    void modify(Long id,DiaryReq req);
    void remove(Long id);
    void like(Long id);
}
