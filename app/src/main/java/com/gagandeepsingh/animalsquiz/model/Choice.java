package com.gagandeepsingh.animalsquiz.model;

public class Choice {
    private int mNextPage;

    public Choice(int nextPage) {
        mNextPage = nextPage;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
