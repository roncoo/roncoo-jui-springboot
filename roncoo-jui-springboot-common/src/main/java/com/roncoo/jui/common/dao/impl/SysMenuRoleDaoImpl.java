package com.roncoo.jui.common.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.jui.common.dao.SysMenuRoleDao;
import com.roncoo.jui.common.entity.SysMenuRole;
import com.roncoo.jui.common.entity.SysMenuRoleExample;
import com.roncoo.jui.common.mapper.SysMenuRoleMapper;
import com.roncoo.jui.common.util.PageUtil;
import com.roncoo.jui.common.util.jui.Page;

@Repository
public class SysMenuRoleDaoImpl implements SysMenuRoleDao {
    @Autowired
    private SysMenuRoleMapper sysMenuRoleMapper;

    public int save(SysMenuRole record) {
        return this.sysMenuRoleMapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.sysMenuRoleMapper.deleteByPrimaryKey(id);
    }

    public int updateById(SysMenuRole record) {
        return this.sysMenuRoleMapper.updateByPrimaryKeySelective(record);
    }

    public SysMenuRole getById(Long id) {
        return this.sysMenuRoleMapper.selectByPrimaryKey(id);
    }

    public Page<SysMenuRole> listForPage(int pageCurrent, int pageSize, SysMenuRoleExample example) {
        int count = this.sysMenuRoleMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<SysMenuRole>(count, totalPage, pageCurrent, pageSize, this.sysMenuRoleMapper.selectByExample(example));
    }
}