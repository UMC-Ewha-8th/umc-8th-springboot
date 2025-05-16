package yooni.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yooni.spring.apiPayload.code.exception.handler.TempHandler;
import yooni.spring.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}