package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.dao.ManagerList;
import bitcamp.java110.cms.dao.StudentList;
import bitcamp.java110.cms.domain.Manager;

public class ManagerController {

    public static Scanner keyIn;
    
    public static void serviceManagerMenu() {
        while(true) {
            System.out.print("매니저 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printManagers();
            } else if(command.equals("add")){
                inputManagers();
            } else if(command.equals("delete")){
                deleteManager();
            } else if(command.equals("detail")){
                detailManager();
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }
    
    private static void printManagers() {
        for(int i = 0; i < StudentList.size(); i++){
            Manager s = ManagerList.get(i);
            System.out.printf("%s, %s, %s, %s, %s\n",
                    s.getNames(), 
                    s.getEmails(),
                    s.getPasswords(),
                    s.getTel(),
                    s.getPosition());
        }
    }
    
    
    private static void inputManagers() {
        while(true) {
            Manager m = new Manager();
            
            System.out.print("이름? ");
            m.setNames(keyIn.nextLine());

            System.out.print("이메일? ");
            m.setEmails(keyIn.nextLine());

            System.out.print("암호? ");
            m.setPasswords(keyIn.nextLine());

            System.out.print("전화번호? ");
            m.setTel(keyIn.nextLine());

            System.out.print("직책? ");
            m.setPosition(keyIn.nextLine());
            
            ManagerList.add(m);
            
            System.out.print("계속 하시겠습니까? (Y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }


    private static void deleteManager() {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.next());

        if (no < 0 || no >= ManagerList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        ManagerList.remove(no);
        
        System.out.println("삭제하였습니다.");
    }
    
    private static void detailManager() {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.next());

        if (no < 0 || no >= ManagerList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Manager manager = ManagerList.get(no);
        
        System.out.printf("이름: %s\n", manager.getNames());
        System.out.printf("이메일: %s\n", manager.getEmails());
        System.out.printf("암호: %s\n", manager.getPasswords());
        System.out.printf("전화: %s\n", manager.getTel());
        System.out.printf("직책: %s\n", manager.getPosition());
    }
    
    static {
        Manager s = new Manager();
        s.setNames("a");
        ManagerList.add(s);
        
        s = new Manager();
        s.setNames("b");
        ManagerList.add(s);
        
        s = new Manager();
        s.setNames("c");
        ManagerList.add(s);
        
        s = new Manager();
        s.setNames("d");
        ManagerList.add(s);
        
        s = new Manager();
        s.setNames("e");
        ManagerList.add(s);
    }



}
