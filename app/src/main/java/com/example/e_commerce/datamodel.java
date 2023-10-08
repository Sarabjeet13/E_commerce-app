package com.example.e_commerce;

public class datamodel
{
    int image;
    String imagename,imagerate;

    public datamodel(int image, String imagename, String imagerate) {
        this.image = image;
        this.imagename = imagename;
        this.imagerate = imagerate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImagerate() {
        return imagerate;
    }

    public void setImagerate(String imagerate) {
        this.imagerate = imagerate;
    }
}
