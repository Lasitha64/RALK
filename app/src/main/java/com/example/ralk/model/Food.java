package com.example.ralk.model;

public class Food {
    private String Name;
    private String Description;
    private String Price;
    private Integer MenuId;
    private String Image;

    public Food(String name, String description, String price, Integer menuId, String image) {
        Name = name;
        Description = description;
        Price = price;
        MenuId = menuId;
        Image = image;
    }

    public Food() {
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public Integer getMenuId() {
        return MenuId;
    }

    public void setMenuId(Integer menuId) {
        MenuId = menuId;
    }
}
