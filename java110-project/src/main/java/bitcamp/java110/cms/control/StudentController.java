package bitcamp.java110.cms.control;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Student;

public class StudentController implements Controller {

    private List<Student> students;
    
    public StudentController(List<Student> students) {
        this.students = students;
        init();
    }
    
    public void service(Scanner keyIn) {
        while(true) {
            System.out.print("학생 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printStudents();
            } else if(command.equals("add")){
                inputStudents(keyIn);
            } else if(command.equals("delete")){
                deleteStudent(keyIn);
            } else if(command.equals("detail")){
                detailStudent(keyIn);
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }
    
    private void printStudents() {
        for(int i = 0; i < students.size(); i++){
            Student s = students.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %b, %s\n",
                    i,
                    s.getNames(), 
                    s.getEmails(),
                    s.getPasswords(),
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());

        }
    }

    private void inputStudents(Scanner keyIn) {
        while(true) {
            Student m = new Student();
            
            System.out.print("이름? ");
            m.setNames(keyIn.nextLine());

            System.out.print("이메일? ");
            m.setEmails(keyIn.nextLine());

            System.out.print("암호? ");
            m.setPasswords(keyIn.nextLine());

            System.out.print("최종학력? ");
            m.setSchool(keyIn.nextLine());

            System.out.print("재직여부?(true/false) ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화번호? ");
            m.setTel(keyIn.nextLine());
            
            students.add(m);
            
            System.out.print("계속 하시겠습니까? (Y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }



    private void deleteStudent(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.next());

        if (no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        students.remove(no);
        
        System.out.println("삭제하였습니다.");
    }
    
    private void detailStudent(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.next());

        if (no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
       
        Student student = students.get(no);
        
        System.out.printf("이름: %s\n", student.getNames());
        System.out.printf("이메일: %s\n", student.getEmails());
        System.out.printf("암호: %s\n", student.getPasswords());
        System.out.printf("최종학력: %s\n", student.getSchool());
        System.out.printf("재직여부: %b\n", student.isWorking());
        System.out.printf("전화: %s\n", student.getTel());
    }
    
    private void init() {// 인스턴스 블록
        Student s = new Student();
        s.setNames("a");
        students.add(s);
        
        s = new Student();
        s.setNames("b");
        students.add(s);
        
        s = new Student();
        s.setNames("c");
        students.add(s);
        
        s = new Student();
        s.setNames("d");
        students.add(s);
        
        s = new Student();
        s.setNames("e");
        students.add(s);
    }
}

