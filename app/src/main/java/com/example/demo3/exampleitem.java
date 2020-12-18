package com.example.demo3;

public class exampleitem {

    private int ImageResource;

    public exampleitem(int imageResource, String text1, String text2) {
        ImageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;
    }

    private String text1;
    private String text2;

    public int getImageResource() {
        return ImageResource;
    }

    public void setImageResource(int imageResource) {
        ImageResource = imageResource;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }





}
