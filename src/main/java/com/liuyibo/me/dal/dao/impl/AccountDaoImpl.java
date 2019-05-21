package com.liuyibo.me.dal.dao.impl;

import com.liuyibo.me.dal.dao.AccountDao;
import com.liuyibo.me.dal.dao.BaseDaoSupport;
import com.liuyibo.me.dal.po.AccountPo;
import com.liuyibo.me.exception.DaoException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
@Repository
public class AccountDaoImpl extends BaseDaoSupport implements AccountDao {

    @Override
    public AccountPo selectById(Integer id) {
        String sql = "select * from um.am_account where id = :id";
        try {
            return getNamedParameterJdbcTemplate().queryForObject(sql,
                new MapSqlParameterSource("id", id),
                new BeanPropertyRowMapper<>(AccountPo.class));
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
    }

}
