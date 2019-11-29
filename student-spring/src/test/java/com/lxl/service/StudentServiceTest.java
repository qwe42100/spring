package com.lxl.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getPageInfo() { studentService.getPageInfo(null,1,2);
    }

    @Test
    public void save() {
    }

    @Test
    public void delByIds() {
    }

    @Test
    public void getById() {
    }
}
