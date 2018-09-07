package bitcamp.java110.cms.context;

import java.util.HashMap;

public class ApplicationContext {
    HashMap<String, Object> objPool = new HashMap<>;
    
    public ApplicationContext(String packageName) {
        // 1) 인스턴스 생성
        // 해당 패키지에 있는 클래스를 찾아서 인스턴스를 생성한 후에 ObjPool에 보관한다.
    }
    
    public Object getBean(String name) {
        // objPool에서 주어진 이름의 객체를 찾아 리턴한다.
        return null;
    }
}
