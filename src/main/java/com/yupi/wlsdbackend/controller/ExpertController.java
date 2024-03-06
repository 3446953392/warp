package com.yupi.wlsdbackend.controller;

import com.yupi.wlsdbackend.domain.Committee;
import com.yupi.wlsdbackend.domain.Expert;
import com.yupi.wlsdbackend.service.CommitteeService;
import com.yupi.wlsdbackend.service.ExpertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class ExpertController {
    @Resource
    private ExpertService expertService;
    @Resource
    private CommitteeService committeeService;

    @GetMapping("/getAllExpert")
    public List<Expert> getAllExpert() {
        return expertService.list();
    }

    @GetMapping("/getAllCommittee")
    public List<Committee> getAllCommittee() {
        return committeeService.list();
    }
}
