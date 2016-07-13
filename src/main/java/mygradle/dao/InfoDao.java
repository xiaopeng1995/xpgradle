package mygradle.dao;

import mygradle.base.entity.Info;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaopeng on 2016/7/13.
 */
@Transactional
public interface InfoDao extends CrudRepository<Info,Integer> {
    @Query("select u from info u where infoid=?1")
    List<Info> findbyinfoid(int id);
}