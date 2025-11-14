package com.example.demo.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {

    public EmpVO getEmp(EmpVO empVO);
    public List<EmpVO> getEmpList(EmpVO empVO);
    public void empInsert(EmpVO empVO);
    public void empDelete(EmpVO empVO);
    public void empUpdate(EmpVO empVO);
    public List<Map<String, Object>> getDeptEmpCnt();
}
