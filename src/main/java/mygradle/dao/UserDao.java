package mygradle.dao;

import mygradle.base.entity.Userinfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaopeng on 2016/7/10.
 */
@Transactional
public interface UserDao extends CrudRepository<Userinfo,Integer> {
    @Query("select u from user u  where name=?1")
    List<Userinfo> findbyname(String name);

}
