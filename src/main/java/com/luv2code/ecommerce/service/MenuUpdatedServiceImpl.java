package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.WeeklyMenuRepository;
import com.luv2code.ecommerce.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MenuUpdatedServiceImpl implements MenuUpdatedService{
    private WeeklyMenuRepository weeklyMenuRepository;
    MenuUpdatedServiceImpl(WeeklyMenuRepository weeklyMenuRepository)
    {
       this.weeklyMenuRepository= weeklyMenuRepository;
    }
    @Override
    public void updateMenu(Menu []updateMenu) {
        List<Menu> updMenu=Arrays.asList(updateMenu);
        this.weeklyMenuRepository.saveAll(updMenu);
        System.out.println("hjhjhj");
    }

}
