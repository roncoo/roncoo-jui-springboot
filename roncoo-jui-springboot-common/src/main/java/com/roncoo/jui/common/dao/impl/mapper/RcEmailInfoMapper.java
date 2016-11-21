package com.roncoo.jui.common.dao.impl.mapper;

import com.roncoo.jui.common.bean.RcEmailInfo;
import com.roncoo.jui.common.bean.RcEmailInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RcEmailInfoMapper {
    int countByExample(RcEmailInfoExample example);

    int deleteByExample(RcEmailInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcEmailInfo record);

    int insertSelective(RcEmailInfo record);

    List<RcEmailInfo> selectByExample(RcEmailInfoExample example);

    RcEmailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcEmailInfo record, @Param("example") RcEmailInfoExample example);

    int updateByExample(@Param("record") RcEmailInfo record, @Param("example") RcEmailInfoExample example);

    int updateByPrimaryKeySelective(RcEmailInfo record);

    int updateByPrimaryKey(RcEmailInfo record);
}