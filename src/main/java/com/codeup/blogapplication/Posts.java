package com.codeup.blogapplication;

public class Posts {
    private String title;
    private String body;

        public Posts(){

        }

        public Posts(String title, String body){
            this.title = title;
            this.body = body;
        }

    public String getTitle(){
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setBody(String body){
        this.body = body;
    }
}
