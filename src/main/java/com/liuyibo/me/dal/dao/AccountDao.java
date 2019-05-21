package com.liuyibo.me.dal.dao;

import com.liuyibo.me.dal.po.AccountPo;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
public interface AccountDao {

    AccountPo selectById(Integer id);

}
