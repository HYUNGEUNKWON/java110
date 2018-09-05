import java.util.Scanner;

public class App {
    
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.
    static class Member {
        protected String names;
        protected String emails;
        protected String passwords;
        
        // 인스턴스의 메모리를 다루는 operator = setter/getter = accessor = property = message
        public String getNames() {
            return names;
        }
        public void setNames(String names) {
            this.names = names;
        }
        public String getEmails() {
            return emails;
        }
        public void setEmails(String emails) {
            this.emails = emails;
        }
        public String getPasswords() {
            return passwords;
        }
        public void setPasswords(String passwords) {
            this.passwords = passwords;
        }
        
        
    }

    static class Student extends Member {
        protected String school;
        protected boolean working;
        protected String tel;
        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        
        
    }
    
    static Student[] students = new Student[100];

    static int index = 0;

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            String menu = promptMenu();

            if(menu.equals("1")) {
                serviceStudentMenu();
            } else if(menu.equals("0")){
                System.out.println("안녕히 가세요!");
                break;
            }
        }
        keyIn.close();
    }
    private static void serviceStudentMenu() {
        while(true) {
            System.out.print("학생 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printStudents();
            } else if(command.equals("add")){
                inputStudents();
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }

    private static String promptMenu() {
        //사용자로부터 메뉴를 입력 받기
        System.out.println("[메뉴]");
        System.out.println("1. 학생 관리");
        System.out.println("2. 강사 관리");
        System.out.println("3. 매니저 관리");
        System.out.println("0. 종료");

        while(true) {
            System.out.print("메뉴 번호> ");

            String menu = keyIn.nextLine();

            switch(menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("메뉴 번호가 유효하지 않습니다.");
            }
        }

    }

    static void printStudents() {
        int count = 0;
        for(Student s : students){
            if(count++ == index)
                break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n",
                    s.getNames(), 
                    s.getEmails(),
                    s.getPasswords(),
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());

        }
    }
    static void inputStudents() {
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

            System.out.print("재직여부? ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화번호? ");
            m.setTel(keyIn.nextLine());
            
            students[index++] = m;

            System.out.print("계속 하시겠습니까? (Y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}