package yooni.spring.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import yooni.spring.domain.Mission;
import yooni.spring.domain.QMember;
import yooni.spring.domain.QMission;
import org.springframework.data.domain.Pageable;
import yooni.spring.domain.mapping.QMemberMission;

import java.util.List;

@RequiredArgsConstructor
public class MissionQueryRepositoryImpl implements MissionQueryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Mission> findMissionsByUserId(Long userId, Pageable pageable) {
        QMission mission = QMission.mission;
        QMemberMission memberMission = QMemberMission.memberMission;
        QMember member = QMember.member;

        return queryFactory
                .selectFrom(mission)
                .join(mission.memberMissionList, memberMission)
                .join(memberMission.member, member)
                .where(member.id.eq(userId)) // 여기서 userId는 memberId
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}

