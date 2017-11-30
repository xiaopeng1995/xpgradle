package mygradle.dao;

import mygradle.base.entity.Serverinfo;
import mygradle.base.entity.Tokeninfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaopeng on 2017/11/27.
 */
@Transactional
public interface TokenDao extends CrudRepository<Tokeninfo, Integer> {
    @Query("select s from token s  where id=?1")
    List<Serverinfo> findbyname(String id);
}

