package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.entity.Menu;
import com.luv2code.ecommerce.service.MenuUpdatedService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://peaceful-mountain-91250.herokuapp.com/")
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
    @GetMapping("/menu")
    public String list() {

        return "this.menuUpdatedService.listAllUser()";
    }

}
