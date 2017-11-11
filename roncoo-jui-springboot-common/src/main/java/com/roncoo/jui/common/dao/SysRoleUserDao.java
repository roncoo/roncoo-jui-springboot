package com.roncoo.jui.common.dao;

import com.roncoo.jui.common.entity.SysRoleUser;
import com.roncoo.jui.common.entity.SysRoleUserExample;
import com.roncoo.jui.common.util.jui.Page;

public interface SysRoleUserDao {
    int save(SysRoleUser record);

    int deleteById(Long id);

    int updateById(SysRoleUser record);

    SysRoleUser getById(Long id);

    Page<SysRoleUser> listForPage(int pageCurrent, int pageSize, SysRoleUserExample example);
}