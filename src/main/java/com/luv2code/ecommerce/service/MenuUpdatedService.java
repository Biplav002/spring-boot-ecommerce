package com.luv2code.ecommerce.service;


import com.luv2code.ecommerce.entity.Menus;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MenuUpdatedService {
    public void updateMenu(Menus[] menu);
    public List<Menus> getMenu();
    Menus getMenuById(long id);
}
