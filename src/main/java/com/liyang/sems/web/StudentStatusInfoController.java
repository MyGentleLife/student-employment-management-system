package com.liyang.sems.web;
import com.liyang.sems.core.Result;
import com.liyang.sems.core.ResultGenerator;
import com.liyang.sems.model.StudentStatusInfo;
import com.liyang.sems.service.StudentStatusInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by LiYang on 2020/11/16.
*/
@RestController
@RequestMapping("/studentstatusinfo")
@CrossOrigin
@Api(tags = "学生基础信息管理")
public class StudentStatusInfoController {
    @Resource
    private StudentStatusInfoService studentStatusInfoService;

    @ApiOperation(value = "学生基础信息-添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody StudentStatusInfo studentStatusInfo) {
        studentStatusInfoService.save(studentStatusInfo);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "学生基础信息-根据id删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@RequestParam Integer id) {
        studentStatusInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "学生基础信息-根据id更新")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(StudentStatusInfo studentStatusInfo) {
        studentStatusInfoService.update(studentStatusInfo);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "学生基础信息-根据id查询")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@RequestParam Integer id) {
        StudentStatusInfo studentStatusInfo = studentStatusInfoService.findById(id);
        return ResultGenerator.genSuccessResult(studentStatusInfo);
    }

    @ApiOperation(value = "学生基础信息-分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StudentStatusInfo> list = studentStatusInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "学生信息-获得学生省份分布人数")
    @RequestMapping(value = "/getprovinceinfo", method = RequestMethod.GET)
    public Result getProvinceInfo() {
        return studentStatusInfoService.getProvinceInfo();
    }

}
