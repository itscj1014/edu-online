package com.guli.edu.controller.admin;


import com.guli.common.vo.R;
import com.guli.edu.entity.Teacher;
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

}
