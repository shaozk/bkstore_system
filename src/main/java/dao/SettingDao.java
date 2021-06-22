package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Book;
import pojo.Setting;

import java.util.List;

/**
 * @author shaozk
 */
@Repository
@Mapper
public interface SettingDao {

    /**
     * 保存
     * @param setting
     * @return
     */
    int save(Setting setting);

    /**
     * 通过key查找
     * @param key
     * @return
     */
    Setting findOneByKey(String key);


}
