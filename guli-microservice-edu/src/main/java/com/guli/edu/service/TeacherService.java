package com.guli.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.edu.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author shuchuanjun
 * @since 2019-08-13
 */
public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> pageQuery(Page<Teacher> pageParm, TeacherQuery teacherQuery);
}
