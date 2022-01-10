package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.WeeklyMenuRepository;

import com.luv2code.ecommerce.entity.Menus;
import org.springframework.stereotype.Service;

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
    public void updateMenu(Menus []updateMenu) {
        List<Menus> updMenu=Arrays.asList(updateMenu);
        this.weeklyMenuRepository.saveAll(updMenu);
        System.out.println("hjhjhj");
    }

    @Override
    public List<Menus> getMenu() {
      return this.weeklyMenuRepository.findAll();
      //return  listMenu.toArray(new Menu[0]);
    }



   @Override
    public Menus getMenuById(long id) {
        return this.weeklyMenuRepository.getById(id);
        //return  listMenu.toArray(new Menu[0]);
    }
}
