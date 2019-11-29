package com.lxl.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.lxl.pojo.Officetool;
import com.lxl.service.OfficetoolService;
import com.lxl.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("off")
public class OfficetoolController {
    @Autowired
    private OfficetoolService officetoolService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("list")
    public Object list(Officetool officetool, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "3") Integer pageSize){
        return officetoolService.selectObject(officetool,pageNo,pageSize);
    }
    @RequestMapping("insert")
    public Object insert(@RequestBody Officetool officetool){
        return officetoolService.insert(officetool);
    }
    @RequestMapping("update")
    public Object update(Officetool officetool){
        return officetoolService.update(officetool);
    }
    @RequestMapping("deleteById")
    public Object deleteById(String ids){
        return officetoolService.deleteById(ids);
    }
    @RequestMapping("getById")
    public Object getById(Integer id){
        return officetoolService.getById(id);
    }
    @RequestMapping("selectList")
    public Object selectList(){
        System.out.println(typeService.selectList()+"--------");
        return typeService.selectList();
    }

}
