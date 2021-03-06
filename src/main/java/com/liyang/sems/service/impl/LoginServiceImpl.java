package com.liyang.sems.service.impl;

import com.liyang.sems.core.Result;
import com.liyang.sems.core.ResultGenerator;
import com.liyang.sems.dao.StudentMapper;
import com.liyang.sems.dao.TeacherMapper;
import com.liyang.sems.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Result login(Integer judge, String name, String password) {
        if(judge == 0) {
                return ResultGenerator.genSuccessResult(studentMapper.login(name, password));
        }else {
                return ResultGenerator.genSuccessResult(teacherMapper.login(name, password));
        }
    }
}
