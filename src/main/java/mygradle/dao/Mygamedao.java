package mygradle.dao;

/**
 * Created by xiaopeng on 2016/7/9.
 */

import mygradle.base.entity.Mygame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Mygamedao extends CrudRepository<Mygame,Integer> {
    public Mygame findByusername(String username);
}
