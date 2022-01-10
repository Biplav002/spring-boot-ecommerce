package com.luv2code.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "image_table")
public class ImageModel {
    public ImageModel() {
        super();
    }
    public ImageModel(Long id,String name, String type, byte[] picByte) {
        this.id=id;
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "day")
    private String name;
    @Column(name = "type")
    private String type;
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Column(name = "pic_Byte", length = 8000)
    private byte[] picByte;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public byte[] getPicByte() {
        return picByte;
    }
    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}