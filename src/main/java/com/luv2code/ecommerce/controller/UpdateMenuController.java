package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.entity.Menu;
import com.luv2code.ecommerce.service.MenuUpdatedService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/update")

public class UpdateMenuController {
    private MenuUpdatedService menuUpdatedService;
    UpdateMenuController(MenuUpdatedService menuUpdatedService){
        this.menuUpdatedService=menuUpdatedService;
    }
    @PostMapping("/menu")
    public void placeOrder(@RequestBody Menu[] menus) {
        this.menuUpdatedService.updateMenu(menus);
       // PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
System.out.println(menus);

        //return purchaseResponse;
    }
    @GetMapping("")
    public String list() {

        return "this.menuUpdatedService.listAllUser()";
    }

}
