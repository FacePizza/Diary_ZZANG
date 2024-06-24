package kr.hs.dgsw.Template.Diary.Service.Query;

import kr.hs.dgsw.Template.Diary.DTO.DiaryResponse;
import kr.hs.dgsw.Template.Diary.Repository.Query.DiaryQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryQueryServiceImpl implements DiaryQueryService{

    private final DiaryQueryRepository diaryQueryRepository;

    @Override
    public List<DiaryResponse> findDiaryList() {
        return diaryQueryRepository.findDiaryList();
    }
}
