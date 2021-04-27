package com.imooc.service;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author admin
 */
public class StuServiceImpl implements StuService {

    @Autowired
    public StuMapper stuMapper;

    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveStu() {
        Stu stu = new Stu();
        stu.setAge(12);
        stu.setName("jack");
        stuMapper.insert(stu);
    }

    @Override
    public void updateStu(int id) {
        Stu stu = new Stu();
        stu.setName("mayun");
        stu.setAge(123);
    }

    @Override
    public void deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }
}
