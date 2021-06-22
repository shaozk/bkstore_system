package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Setting;

import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class SettingDaoTest {

    @Autowired
    private SettingDao settingDao;

    @Test
    public void save() {
        Setting settin = settingDao.findOneByKey("test_key");
        if(settin != null) {
            System.out.println(settin);
        } else {
            Setting setting = new Setting();
            setting.setId("123");
            setting.setKey("test_key");
            setting.setValue("test_value");
            setting.setCreateTime(new Date());
            setting.setUpdateTime(new Date());

            int code = settingDao.save(setting);
            assert code == 1;
        }
    }

    @Test
    public void findOneByKey() {
        Setting setting = settingDao.findOneByKey("test_key");
        if(setting == null) {
            System.out.println("空指针异常");
        }
        assert setting.getId().equals("123");
        System.out.println(setting.getCreateTime());
        System.out.println(setting);

    }
}