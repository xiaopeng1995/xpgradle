package mygradle.dao;

import mygradle.base.entity.Serverinfo;
import mygradle.base.entity.Userinfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaopeng on 2017/11/27.
 */
@Transactional
public interface ServerDao extends CrudRepository<Serverinfo, Integer> {
    @Query("select u from server u  where nametype=?1")
    List<Serverinfo> findbyname(String name);
}

