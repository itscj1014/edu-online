package com.guli.edu.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.vo.R;
import com.guli.edu.entity.Teacher;
import com.guli.edu.query.TeacherQuery;
import com.guli.edu.service.TeacherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "教师管理", description = "教师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherAdminController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public R teacherList() {
        System.out.println("请求进来了");
        List<Teacher> teacherList = teacherService.list(null);
        return R.ok().data("items",teacherList);
    }

    @DeleteMapping("{id}")
    public R removeTeacherById(@PathVariable("id") String id) {
        teacherService.removeById(id);
        return R.ok();
    }

    @GetMapping("{page}/{limit}")
    public R tearchPage(@PathVariable("page")Integer page, @PathVariable("limit") Integer limit, TeacherQuery teacherQuery) {
        Page<Teacher> pageParm = new Page<>(page, limit);
        IPage<Teacher> teacherIPage = teacherService.pageQuery(pageParm,teacherQuery);
        List<Teacher> records = teacherIPage.getRecords();
        long total = teacherIPage.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

}
