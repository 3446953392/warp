package com.yupi.wlsdbackend.controller;

import com.yupi.wlsdbackend.domain.MediaVideo;
import com.yupi.wlsdbackend.service.MediaVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class MediaVideoController {
    @Resource
    private MediaVideoService mediaVideoService;

    @GetMapping("/getAllMediaVideo")
    public List<MediaVideo> getAllMediaVideo() {
        return mediaVideoService.list();
    }
}
