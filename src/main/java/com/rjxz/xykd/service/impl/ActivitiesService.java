package com.rjxz.xykd.service.impl;

import com.rjxz.xykd.bean.Activities;
import com.rjxz.xykd.dao.ActivitiesMapper;
import com.rjxz.xykd.service.IActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitiesService implements IActivitiesService {

    @Autowired
    private ActivitiesMapper activitiesMapper;

    @Override
    public List<Activities> getActivities(Long userId) {
        return activitiesMapper.selectById(userId);
    }

    @Override
    public List<Activities> getAllActivities() {
        return activitiesMapper.selectAll();
    }

    @Override
    public boolean deleteActivity(Long id) {
        return activitiesMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean insertActivities(Activities activities) {
        return activitiesMapper.insert(activities) > 0;
    }

    @Override
    public boolean updateActivities(Activities activities) {
        return activitiesMapper.updateByPrimaryKey(activities) > 0;
    }
}
