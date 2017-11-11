package com.roncoo.jui.common.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.jui.common.dao.SysMenuDao;
import com.roncoo.jui.common.entity.SysMenu;
import com.roncoo.jui.common.entity.SysMenuExample;
import com.roncoo.jui.common.mapper.SysMenuMapper;
import com.roncoo.jui.common.util.PageUtil;
import com.roncoo.jui.common.util.jui.Page;

@Repository
public class SysMenuDaoImpl implements SysMenuDao {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    public int save(SysMenu record) {
        return this.sysMenuMapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.sysMenuMapper.deleteByPrimaryKey(id);
    }

    public int updateById(SysMenu record) {
        return this.sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    public SysMenu getById(Long id) {
        return this.sysMenuMapper.selectByPrimaryKey(id);
    }

    public Page<SysMenu> listForPage(int pageCurrent, int pageSize, SysMenuExample example) {
        int count = this.sysMenuMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<SysMenu>(count, totalPage, pageCurrent, pageSize, this.sysMenuMapper.selectByExample(example));
    }
}