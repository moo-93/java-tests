package bitcamp.javatest.cms.control.teacher;

import java.util.Scanner;

import bitcamp.javatest.cms.annotation.Autowired;
import bitcamp.javatest.cms.annotation.Component;
import bitcamp.javatest.cms.annotation.RequestMapping;
import bitcamp.javatest.cms.dao.TeacherDao;
import bitcamp.javatest.cms.domain.Teacher;

@Component
public class TeacherAddController {
    TeacherDao teacherDao;

    @Autowired
    public void setTeahcerDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
        while(true) {
            Teacher t = new Teacher();

            System.out.print("이름  > ");
            t.setName(keyIn.nextLine()); 

            System.out.print("이메일 > ");
            t.setEmail(keyIn.nextLine()); 

            System.out.print("암호 > ");
            t.setPassword(keyIn.nextLine()); 

            System.out.print("시급 > ");
            t.setPay(Integer.parseInt(keyIn.nextLine())); 

            System.out.print("강의과목 (예: C, C++, 자바) > ");
            t.setSubjects(keyIn.nextLine()); 

            System.out.print("전화번호 > ");
            t.setTel(keyIn.nextLine()); 

            System.out.println("continue?(Y/n)");
            
            if(teacherDao.insert(t) > 0) {
                System.out.println("저장 완료!");
            } else {
                System.out.println("입력하신 이메일이 존재합니다.");
            }
            
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}
