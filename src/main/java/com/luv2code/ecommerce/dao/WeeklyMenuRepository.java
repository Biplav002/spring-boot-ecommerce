package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Menu;
import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface WeeklyMenuRepository extends JpaRepository<Menu,Long> {
    Page<Menu> findById(@RequestParam("id") Long id, Pageable pageable);
}
