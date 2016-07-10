package mygradle.dao;

import mygradle.base.entity.Userinfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiaopeng on 2016/7/10.
 */
@Transactional
public interface UserDao extends CrudRepository<Userinfo,Integer> {
}
