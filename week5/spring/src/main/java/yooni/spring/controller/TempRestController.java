package yooni.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yooni.spring.apiPayload.ApiResponse;
import yooni.spring.converter.TempConverter;
import yooni.spring.dto.TempResponse;
import yooni.spring.service.TempQueryService;

@RestController
@RequestMapping("/temp")
public class TempRestController {

    private final TempQueryService tempQueryService;

    public TempRestController(@Qualifier("tempQueryServiceImpl") TempQueryService tempQueryService) {
        this.tempQueryService = tempQueryService;
    }

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}