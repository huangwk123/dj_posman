package com.dj.ssm.web;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.User;
import com.dj.ssm.service.UserService;
import com.dj.ssm.unti.HttpClientUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * userController处理类
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 列表展示
     *
     * @return
     */
    @GetMapping
    public ResultModel<Object> list() {
        try {
            List<User> list = userService.list();
            return new ResultModel<>().success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常,请稍后再试");
        }

    }

    /**
     * 数据的新增
     *
     * @param user
     * @return
     */
    @PostMapping
    public ResultModel<Object> save(User user) {
        /*  public ResultModel<Object> save(@RequestBody User user) {*/
        try {
            userService.save(user);
            return new ResultModel<>().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常,请稍后再试");
        }
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @PutMapping
    public ResultModel<Object> update(@RequestBody User user) {
   /* public ResultModel<Object> update( User user) {*/
        try {
            userService.updateById(user);
            return new ResultModel<>().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常,请稍后再试");
        }
    }

    /**
     * 删除
     *
     * @param
     * @return
     */
    @DeleteMapping()
  /*  @DeleteMapping("/{id}")*/
    /* public ResultModel<Object> del(@PathVariable Integer id) {*/
  /*  public ResultModel<Object> del( @RequestBody Integer id) {*/
    public ResultModel<Object> del(@RequestBody User user) {
        try {
            userService.removeById(user.getId());
            return new ResultModel<>().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常,请稍后再试");
        }

    }

    /**
     * 列表
     *
     * @param user
     * @return
     */
    @PostMapping("/list2")
    public ResultModel<Object> list2(@RequestBody User user) {
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            // queryWrapper.like("user_name","z");
            userService.list(queryWrapper);
            return new ResultModel<>().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常,请稍后再试");
        }

    }

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("upload")
    public ResultModel<Object> upload(MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            System.out.println(filename);
            if (!file.isEmpty()) {
                String dirPath = "E:/upload/";
                File f = new File(dirPath);
                if (!f.exists()) {
                    f.mkdirs();
                }
                file.transferTo(new File(dirPath + filename));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 正向代理
     *
     * @return
     */
    @RequestMapping("/show")
    public ResultModel<Object> show(String url) {
        try {
            String s = HttpClientUtil.sendHttpRequest(url, HttpClientUtil.HttpRequestMethod.GET, null);
            System.out.println(s);
            JSONObject object = JSONObject.parseObject(s);
            if (object.getInteger("code").equals(200)) {
                return new ResultModel<>().success(object.get("data"));
            } else {
                return new ResultModel<>().error(object.getString("msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常,请稍后再试");
        }

    }
}
