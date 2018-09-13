package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
    public int insert(Manager manager) throws MandatoryValueDaoException, DuplicationDaoException;
    public List<Manager> findAll();
    
    public Manager findByEmail(String email);
    default Manager findByNo(int no) {return null;}
    
    default int delete(String email) {return 0;}
    
    // 기존 구현체에는 영향을 안끼치는 새로운 규칙 (default)
    default int deleteByNo(int no) {return 0;}
}
