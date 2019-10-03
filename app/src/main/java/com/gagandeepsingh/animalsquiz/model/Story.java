package com.gagandeepsingh.animalsquiz.model;


import com.gagandeepsingh.animalsquiz.R;

public class Story {

    private Page[] mPages;

    public Story() {
        mPages = new Page[8];

        mPages[0] = new Page(R.drawable.dolphin, "Dolphin");
        mPages[1] = new Page(R.drawable.elephant, "Elephant");
        mPages[2] = new Page(R.drawable.monkey, "Monkey");
        mPages[3] = new Page(R.drawable.dolphin, "Dolphin");
        mPages[4] = new Page(R.drawable.redpanda, "Redpanda");
        mPages[5] = new Page(R.drawable.tiger, "Tiger");
        mPages[6] = new Page(R.drawable.redpanda, "Redpanda");
        mPages[7] = new Page(R.drawable.tiger, "Tiger");
    }

    public Page getPage(int pageNumber) {
        return mPages[pageNumber];
    }

}
