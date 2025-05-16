package yooni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yooni.spring.domain.Mission;

@Repository
public interface MissionQueryRepository extends JpaRepository<Mission, Long>, MissionQueryRepositoryCustom {
}