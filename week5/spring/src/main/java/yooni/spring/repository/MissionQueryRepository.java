package yooni.spring.repository;

import org.springframework.data.domain.Pageable;
import yooni.spring.domain.Mission;

import java.util.List;

public interface MissionQueryRepository {

    List<Mission> findMissionsByUserId(Long userId, Pageable pageable);
}
