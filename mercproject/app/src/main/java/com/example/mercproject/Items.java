package com.example.mercproject;

public class Items {

    private String title;
    private String info;
    private final int imageResource;

    public Items(String title,String info,int imageResource ){
        this.title=title;
        this.info=info;
        this.imageResource=imageResource;
    }

    public Items(int imageResource) {
        this.imageResource = imageResource;
    }

    String getTitle(){return title;}
    String getInfo(){return info;}
    public int getImageResource(){return imageResource;}
}
