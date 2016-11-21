package com.roncoo.jui.common.dao.impl.mapper;

import com.roncoo.jui.common.bean.RcEmailAccountInfo;
import com.roncoo.jui.common.bean.RcEmailAccountInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RcEmailAccountInfoMapper {
    int countByExample(RcEmailAccountInfoExample example);

    int deleteByExample(RcEmailAccountInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcEmailAccountInfo record);

    int insertSelective(RcEmailAccountInfo record);

    List<RcEmailAccountInfo> selectByExample(RcEmailAccountInfoExample example);

    RcEmailAccountInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcEmailAccountInfo record, @Param("example") RcEmailAccountInfoExample example);

    int updateByExample(@Param("record") RcEmailAccountInfo record, @Param("example") RcEmailAccountInfoExample example);

    int updateByPrimaryKeySelective(RcEmailAccountInfo record);

    int updateByPrimaryKey(RcEmailAccountInfo record);
}