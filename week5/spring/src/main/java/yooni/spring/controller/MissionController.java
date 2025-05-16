package yooni.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yooni.spring.domain.Mission;
import yooni.spring.service.MissionQueryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionQueryService missionQueryService;

    @GetMapping("/my")
    public Page<Mission> getMyMissions(@AuthenticationPrincipal MemberDetails memberDetails,
                                       @PageableDefault(size = 10) Pageable pageable) {
        Long userId = memberDetails.getId(); // 또는 .getMember().getId()
        return missionQueryService.getMissionsByUserId(userId, pageable);
    }
}
