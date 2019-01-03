package com.rjxz.xykd.dao;

import com.rjxz.xykd.bean.Activities;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

@CacheNamespace
public interface ActivitiesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activities
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activities
     *
     * @mbg.generated
     */
    int insert(Activities record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activities
     *
     * @mbg.generated
     */
    Activities selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activities
     *
     * @mbg.generated
     */
    List<Activities> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activities
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Activities record);

    List<Activities> selectById(Long userId);
}