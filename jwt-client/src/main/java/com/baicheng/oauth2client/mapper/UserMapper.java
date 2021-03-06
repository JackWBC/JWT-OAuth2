package com.baicheng.oauth2client.mapper;

import com.baicheng.oauth2client.model.UserPO;
import com.baicheng.oauth2client.model.UserPOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    long countByExample(UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    int deleteByExample(UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    @Insert({
        "insert into t_user (user_name, password, ",
        "roles, authorities, ",
        "is_deleted, create_time, ",
        "create_by, update_time, ",
        "update_by)",
        "values (#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{roles,jdbcType=VARCHAR}, #{authorities,jdbcType=VARCHAR}, ",
        "#{isDeleted,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    int insertSelective(UserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    List<UserPO> selectByExampleWithRowbounds(UserPOExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    List<UserPO> selectByExample(UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    @Select({
        "select",
        "id, user_name, password, roles, authorities, is_deleted, create_time, create_by, ",
        "update_time, update_by",
        "from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.baicheng.oauth2client.mapper.UserMapper.BaseResultMap")
    UserPO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserPO record, @Param("example") UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    int updateByExample(@Param("record") UserPO record, @Param("example") UserPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    int updateByPrimaryKeySelective(UserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Feb 26 20:06:19 CST 2019
     */
    @Update({
        "update t_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "roles = #{roles,jdbcType=VARCHAR},",
          "authorities = #{authorities,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserPO record);
}