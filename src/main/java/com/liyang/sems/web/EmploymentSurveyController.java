package com.liyang.sems.web;
import com.liyang.sems.core.Result;
import com.liyang.sems.core.ResultGenerator;
import com.liyang.sems.model.EmploymentSurvey;
import com.liyang.sems.service.EmploymentSurveyService;
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
@RequestMapping("/employmentsurvey")
@CrossOrigin
@Api(tags = "就业意向信息管理")
public class EmploymentSurveyController {
    @Resource
    private EmploymentSurveyService employmentSurveyService;

    @ApiOperation(value = "就业意向信息-添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody EmploymentSurvey employmentSurvey) {
        employmentSurveyService.save(employmentSurvey);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "就业意向信息-根据id删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@RequestParam Integer id) {
        employmentSurveyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "就业意向信息-根据id更新")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(EmploymentSurvey employmentSurvey) {
        employmentSurveyService.update(employmentSurvey);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "就业意向信息-根据id查询")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@RequestParam Integer id) {
        EmploymentSurvey employmentSurvey = employmentSurveyService.findById(id);
        return ResultGenerator.genSuccessResult(employmentSurvey);
    }

    @ApiOperation(value = "就业意向信息-分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<EmploymentSurvey> list = employmentSurveyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "就业意向信息-根据用户id获得info")
    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public Result getInfoById(Integer stuId) {
        return employmentSurveyService.getInfoByUserId(stuId);
    }

}
