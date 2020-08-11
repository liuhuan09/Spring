package com.example.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@Api(value = "测试接口", tags = "UserController", description = "测试接口相关")
public class UserController {


    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "query")
    @ApiOperation(value = "获取用户详细信息", notes = "根据id来获取用户详细信息")
    public Map<String, Object> getUser(@RequestParam Long id) {
        Map<String, Object> ret = new HashMap<>();
        try {

            ret.put("msg", "用户ID：" + id + "，未找到数据");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * paramType:指定参数放在哪个地方
     * path:（用于restful接口）-->请求参数的获取：@PathVariable
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public Map<String, Object> deleteUser(@PathVariable Long id) {
        Map<String, Object> ret = new HashMap<>();
        if (null == id) {
            ret.put("msg", "参数不能为空");
            return ret;
        }
        ret.put("msg", "删除成功");

        return ret;
    }

    /**
     * ApiIgnore 使用该注解忽略这个API，不会生成接口文档。可注解在类和方法上
     *
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    public Map<String, Object> getAll() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("msg", "获取成功");
        return ret;
    }

}