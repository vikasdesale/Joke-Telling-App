package com.joketelling.application.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public MyBean(String myJoke) {
        this.myData=myJoke;
    }

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}