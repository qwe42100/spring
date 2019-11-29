package com.lxl.controller;
import com.lxl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
@RestController
@RequestMapping("/area/")
@CrossOrigin
public class AreaController {
    @Autowired
    private StudentService studentService;

    /**
     * 根据城市pid，查询城市列表
     * @param pid
     * @return
     * @throws IOException
     */
    @RequestMapping("getListByPid")
    public Object getListByPid(Integer pid) throws IOException {
        return studentService.getAreaListByPid(pid);
    }
}
