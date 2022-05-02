package com.luv2code.ecommerce.dao;


import com.luv2code.ecommerce.entity.Menus;
import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin("https://nourriture-app.herokuapp.com")
public interface WeeklyMenuRepository extends JpaRepository<Menus,Long> {
    @Query("select w.day,w.description,w.price ,i.picByte from Menus w left join ImageModel i on  w.day = i.name")
    Page<Menus> findById(@RequestParam("id") Long id, Pageable pageable);
        List<Menus> findAll();



    Menus getByDay(String name);

    Menus getById(long id);
}
