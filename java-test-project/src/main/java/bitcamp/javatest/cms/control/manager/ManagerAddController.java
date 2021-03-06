package bitcamp.javatest.cms.control.manager;

import java.util.Scanner;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.dao.ManagerDao;
import bitcamp.javatest.cms.domain.Manager;

@Component
public class ManagerAddController {
    
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
        while(true) {
            Manager m = new Manager();

            System.out.print("이름  > ");
            m.setName(keyIn.nextLine()); 

            System.out.print("이메일 > ");
            m.setEmail(keyIn.nextLine()); 

            System.out.print("암호 > ");
            m.setPassword(keyIn.nextLine()); 

            System.out.print("포지션 > ");
            m.setPosition(keyIn.nextLine());

            System.out.print("전화번호 > ");
            m.setTel(keyIn.nextLine()); 

            System.out.println("continue?(Y/n)");

            int rtval = 0;
            if((rtval = managerDao.insert(m)) > 0) {
                System.out.println("저장 완료 !");
            } else if(rtval == -1) {
                System.out.println("필수 입력란이 비어있습니다.");
            } else if(rtval == -2) {
                System.out.println("해당 미에일이 존재합니다.");
            } else {
                System.out.println("예기치 못한 오류가 발생하였습니다.");
            }
            
            System.out.print("continue? (Y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}
