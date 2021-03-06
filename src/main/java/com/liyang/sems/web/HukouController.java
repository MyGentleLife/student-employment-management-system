package com.liyang.sems.web;
import com.liyang.sems.core.Result;
import com.liyang.sems.core.ResultGenerator;
import com.liyang.sems.model.Hukou;
import com.liyang.sems.service.HukouService;
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
@RequestMapping("/hukou")
@CrossOrigin
@Api(tags = "户口信息管理")
public class HukouController {
    @Resource
    private HukouService hukouService;

    @ApiOperation(value = "户口信息-添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Hukou hukou) {
        hukouService.save(hukou);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "户口信息-根据id删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@RequestParam Integer id) {
        hukouService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "户口信息-根据id更新")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(Hukou hukou) {
        hukouService.update(hukou);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "户口信息-根据id查询")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@RequestParam Integer id) {
        Hukou hukou = hukouService.findById(id);
        return ResultGenerator.genSuccessResult(hukou);
    }

    @ApiOperation(value = "户口信息-分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Hukou> list = hukouService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
