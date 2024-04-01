package com.ezreal.service;

import com.ezreal.aop.AopLock;
import com.ezreal.entity.AopTestDTO;
import com.ezreal.entity.AopTestRequest;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AopService {

    @AopLock(expressions = "#aopTestRequest.idNo", returnExpressions = "#aopTestDTO.idNo")
    public AopTestDTO get(AopTestRequest aopTestRequest) {
        AopTestDTO aopTestDTO = new AopTestDTO();
        BeanUtils.copyProperties(aopTestRequest, aopTestDTO);
        return aopTestDTO;
    }

    @AopLock(expressions = "#aopTestRequest.idNo", returnExpressions = "#aopTestDTO.idNo")
    public List<AopTestDTO> getList(AopTestRequest aopTestRequest) {
        AopTestDTO aopTestDTO = new AopTestDTO();
        BeanUtils.copyProperties(aopTestRequest, aopTestDTO);
        ArrayList<AopTestDTO> aopTestDTOS = Lists.newArrayList(aopTestDTO, aopTestDTO);
        return aopTestDTOS;
    }

    @AopLock(expressions = "#num", returnExpressions = "#aopTestDTO.idNo")
    public AopTestDTO getNum(Long num) {
        AopTestDTO aopTestDTO = new AopTestDTO();
        return aopTestDTO;
    }
}
