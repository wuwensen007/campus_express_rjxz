package com.rjxz.xykd.service;

import com.rjxz.xykd.bean.Activities;

import java.util.List;

public interface IActivitiesService {
    //获取个人活动记录
    List<Activities> getActivities(Long id);

    //获取所有活动记录
    List<Activities> getAllActivities();

    //删除用户活动记录
    boolean deleteActivity(Long id);

    //添加个人活动记录
    boolean insertActivities(Activities activities);

    //修改活动记录
    boolean updateActivities(Activities activities);
}
