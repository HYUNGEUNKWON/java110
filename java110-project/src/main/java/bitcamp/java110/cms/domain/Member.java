package bitcamp.java110.cms.domain;

public class Member {
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


