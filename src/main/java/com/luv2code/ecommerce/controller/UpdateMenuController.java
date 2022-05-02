package com.luv2code.ecommerce.controller;


import com.luv2code.ecommerce.config.AppConfig;
import com.luv2code.ecommerce.entity.ImageModel;
import com.luv2code.ecommerce.entity.Menus;
import com.luv2code.ecommerce.service.MenuUpdatedService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import static com.luv2code.ecommerce.controller.ImageUploadController.compressBytes;
//https://peaceful-mountain-91250.herokuapp.com/

@CrossOrigin("https://nourriture-app.herokuapp.com")
@RestController


public class UpdateMenuController {

    private AppConfig appConfig;
    private MenuUpdatedService menuUpdatedService;
    UpdateMenuController(MenuUpdatedService menuUpdatedService){
        this.menuUpdatedService=menuUpdatedService;
    }
    @PutMapping("/api/update/menu")
    public void placeOrder(@RequestBody Menus menu) {

      //string table=menu.getDay();

       /* ImageModel img = new ImageModel(menus.getOriginalFilename(), file.getContentType(),
                compressBytes(file.getBytes()));*/
        this.menuUpdatedService.updateMenu(menu);
       // PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
//System.out.println(menus);

        //return purchaseResponse; @GetMapping("/tutorials/{id}")
    }
    @GetMapping("/menu")
    public List<Menus> list() {

        return this.menuUpdatedService.getMenu();
    }
    @GetMapping("/menu/search/findById")
    public Menus getMenuById(@RequestParam("id") long id) {

       //
        Menus m =this.menuUpdatedService.getMenuById(id);
        /*ImageModel img = new ImageModel(getId(m.getImagemodel().getName()),m.getImagemodel().getName(), m.getImagemodel().getType(),
                decompressBytes(m.getImagemodel().getPicByte()));
        m.setImagemodel(img);*/
        return  m;
    }

    @GetMapping("/api/menu/search/findById")
    public Menus getaMenuById(@RequestParam("id") long id) {

        //
        Menus m =this.menuUpdatedService.getMenuById(id);
        /*ImageModel img = new ImageModel(getId(m.getImagemodel().getName()),m.getImagemodel().getName(), m.getImagemodel().getType(),
                decompressBytes(m.getImagemodel().getPicByte()));
        m.setImagemodel(img);*/
        return  m;
    }
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }

    private long getId(String day){
        switch(day) {
            case "Monday":
                return 1;
            case "Tuesday":
                return 2;
            case "Wednesday":
                return 3;
            case "Thrusday":
                return 4;
            case "Friday":
                return 5;
            case "Saturday":
                return 6;
            case "Sunday":
                return 7;

            default:
                return 0;

        }

    }

}
