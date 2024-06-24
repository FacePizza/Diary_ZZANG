package kr.hs.dgsw.Template.Diary.Service;

import kr.hs.dgsw.Template.Diary.DTO.DiaryDTO;

import java.util.List;

public interface DiaryService {
    Long register(DiaryDTO dto);
    List<DiaryDTO> getList();
    DiaryDTO get(Long id);
    void modify(DiaryDTO dto);
    void remove(Long id);
}
