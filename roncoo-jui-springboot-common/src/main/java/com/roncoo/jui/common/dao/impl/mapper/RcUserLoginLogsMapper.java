package com.roncoo.jui.common.dao.impl.mapper;

import com.roncoo.jui.common.bean.RcUserLoginLogs;
import com.roncoo.jui.common.bean.RcUserLoginLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RcUserLoginLogsMapper {
    int countByExample(RcUserLoginLogsExample example);

    int deleteByExample(RcUserLoginLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcUserLoginLogs record);

    int insertSelective(RcUserLoginLogs record);

    List<RcUserLoginLogs> selectByExample(RcUserLoginLogsExample example);

    RcUserLoginLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcUserLoginLogs record, @Param("example") RcUserLoginLogsExample example);

    int updateByExample(@Param("record") RcUserLoginLogs record, @Param("example") RcUserLoginLogsExample example);

    int updateByPrimaryKeySelective(RcUserLoginLogs record);

    int updateByPrimaryKey(RcUserLoginLogs record);
}