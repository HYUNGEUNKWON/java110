package bitcamp.java110.cms.control.manager;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerListController {
    
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        List<Manager> list = managerDao.findAll();
        
        for (Manager m : list) {
            System.out.printf("%d, %s, %s, %s, %s, %s\n", 
                    m.getNo(),
                    m.getName(), 
                    m.getEmail(), 
                    m.getPassword(), 
                    m.getTel(),
                    m.getPosition());
        }
    }
}
