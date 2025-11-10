package com.example.demo.emp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;
import com.example.demo.emp.service.EmpVO;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired EmpMapper empMapper; 

	//단건조회
    @Override
    public EmpVO getEmp(EmpVO empVO) {
        return empMapper.getEmp(empVO);
    }

    //전체조회
    @Override
    public List<EmpVO> getEmpList(EmpVO empVO) {
        System.out.println("getEmpList 서비스 호출");
        return empMapper.getEmpList(empVO);
    }

    //등록
    @Override
    public void empInsert(EmpVO empVO) {
        empMapper.empInsert(empVO);
    }

    @Override
    public void empDelete(EmpVO empVO) {
        
    }

    @Override
    public void empUpdate(EmpVO empVO) {
        
    }

    @Override
    public List<Map<String, Object>> getDeptEmpCnt() {
        return empMapper.getDeptEmpCnt();
    }
}
