package kr.hs.dgsw.Template.Diary.Service;

import kr.hs.dgsw.Template.Diary.DTO.DiaryDTO;
import kr.hs.dgsw.Template.Diary.Entity.DiaryEntity;
import kr.hs.dgsw.Template.Diary.Repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Override
    public Long register(DiaryDTO dto) {
        DiaryEntity _save = diaryRepository.save(dto.toEntity());

        return _save.getId();
    }
}
