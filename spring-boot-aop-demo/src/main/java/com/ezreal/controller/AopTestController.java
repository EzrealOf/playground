package com.ezreal.controller;

import com.ezreal.entity.AopTestDTO;
import com.ezreal.entity.AopTestRequest;
import com.ezreal.entity.AopTestVO;
import com.ezreal.service.AopService;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AopTestController {

    @Autowired
    private AopService aopService;

    @GetMapping("/test")
    public AopTestVO test() {
        AopTestRequest request = new AopTestRequest();
        request.setName("小明");
        request.setIdNo("123456789");
        AopTestDTO aopTestDTO = aopService.get(request);
        AopTestVO aopTestVO = new AopTestVO();
        BeanUtils.copyProperties(aopTestDTO, aopTestVO);
        return aopTestVO;
    }

    @GetMapping("/testList")
    public List<AopTestVO> testList() {
        AopTestRequest request = new AopTestRequest();
        request.setName("小明");
        request.setIdNo("123456789");
        List<AopTestDTO> list = aopService.getList(request);
        List<AopTestVO> resultList = Lists.newArrayList();
        for (AopTestDTO aopTestDTO : list) {
            AopTestVO aopTestVO = new AopTestVO();
            BeanUtils.copyProperties(aopTestDTO, aopTestVO);
            resultList.add(aopTestVO);
        }
        return resultList;
    }

    @GetMapping("/testNum")
    public AopTestVO testNum() {
        AopTestRequest request = new AopTestRequest();
        request.setName("小明");
        request.setIdNo("123456789");
        AopTestDTO aopTestDTO = aopService.getNum(122L);
        AopTestVO aopTestVO = new AopTestVO();
        BeanUtils.copyProperties(aopTestDTO, aopTestVO);
        return aopTestVO;
    }


}
