package com.gagandeepsingh.animalsquiz.model;


public class Page {
    private int mImageId;
    private String mAnimalName;
    private Choice mChoice1;


    public Page(int imageId, String animal ) {
        mImageId = imageId;
        mAnimalName = animal;
    }

    public Page(int imageId, Choice choice1) {
        mImageId = imageId;
        mChoice1 = choice1;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int id) {
        mImageId = id;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public String getAnimalName() {
        return "You are a " + mAnimalName;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }
}
