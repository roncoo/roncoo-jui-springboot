package com.roncoo.jui.common.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.jui.common.dao.SysRoleUserDao;
import com.roncoo.jui.common.entity.SysRoleUser;
import com.roncoo.jui.common.entity.SysRoleUserExample;
import com.roncoo.jui.common.mapper.SysRoleUserMapper;
import com.roncoo.jui.common.util.PageUtil;
import com.roncoo.jui.common.util.jui.Page;

@Repository
public class SysRoleUserDaoImpl implements SysRoleUserDao {
    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    public int save(SysRoleUser record) {
        return this.sysRoleUserMapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.sysRoleUserMapper.deleteByPrimaryKey(id);
    }

    public int updateById(SysRoleUser record) {
        return this.sysRoleUserMapper.updateByPrimaryKeySelective(record);
    }

    public SysRoleUser getById(Long id) {
        return this.sysRoleUserMapper.selectByPrimaryKey(id);
    }

    public Page<SysRoleUser> listForPage(int pageCurrent, int pageSize, SysRoleUserExample example) {
        int count = this.sysRoleUserMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<SysRoleUser>(count, totalPage, pageCurrent, pageSize, this.sysRoleUserMapper.selectByExample(example));
    }
}