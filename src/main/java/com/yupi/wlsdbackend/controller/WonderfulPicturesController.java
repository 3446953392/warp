package com.yupi.wlsdbackend.controller;

import com.yupi.wlsdbackend.domain.WonderfulPictures;
import com.yupi.wlsdbackend.service.WonderfulPicturesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class WonderfulPicturesController {
    @Resource
    private WonderfulPicturesService wonderfulPicturesService;

    @GetMapping("/getAllWonderfulPictures")
    public List<WonderfulPictures> getAllWonderfulPictures() {
        return wonderfulPicturesService.list();
    }
}
