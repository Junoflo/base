package com.liuyibo.me.dao;

import com.liuyibo.me.BaseTest;
import com.liuyibo.me.dal.dao.AccountDao;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
public class AccountDaoTest extends BaseTest {

    @Resource
    private AccountDao accountDao;

    @Test
    public void test() {
        printResult(accountDao.selectById(1));
    }
}
