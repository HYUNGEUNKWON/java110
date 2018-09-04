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
    
    static Member[] members = new Member[100];

    static int index = 0;

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {

        inputMembers();

        printMembers();

        keyIn.close();
    }

    static void printMembers() {
        for(int i = 0; i < index; i++){
            System.out.printf("%s, %s, %s\n", members[i].getNames(), members[i].getEmails(), members[i].getPasswords());
        }
    }
    static void inputMembers() {
        while(true) {
            Member m = new Member();
            System.out.print("이름? ");
            m.setNames(keyIn.nextLine());

            System.out.print("이메일? ");
            m.setEmails(keyIn.nextLine());

            System.out.print("암호? ");
            m.setPasswords(keyIn.nextLine());

            members[index++] = m;

            System.out.print("계속 하시겠습니까? (Y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }
}