package kr.hs.dgsw.Template.Diary.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hs.dgsw.Template.Diary.DTO.DiaryDTO;
import kr.hs.dgsw.Template.Diary.Service.DiaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
@Tag(name = "일기")
@Slf4j
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping
    public ResponseEntity<String> register(DiaryDTO _dto) {
        Long _register = diaryService.register( _dto );

        return ResponseEntity.status(HttpStatus.CREATED).body( _register.toString() );
    }
}
