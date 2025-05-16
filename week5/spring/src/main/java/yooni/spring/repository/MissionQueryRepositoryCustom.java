package yooni.spring.repository;

import yooni.spring.domain.Mission;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MissionQueryRepositoryCustom {
    List<Mission> findMissionsByUserId(Long userId, Pageable pageable);
}
