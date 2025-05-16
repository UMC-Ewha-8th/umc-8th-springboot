package yooni.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yooni.spring.domain.Mission;
import yooni.spring.repository.MissionQueryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryService {

    private final MissionQueryRepository missionQueryRepository;

    public List<Mission> getMissionsByUserId(Long userId, Pageable pageable) {
        return missionQueryRepository.findMissionsByUserId(userId, pageable);
    }
}
