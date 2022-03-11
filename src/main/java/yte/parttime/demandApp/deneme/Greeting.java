package yte.parttime.demandApp.deneme;

import lombok.ToString;

@ToString
public class Greeting {
    public static final String hello="Hello";
    public static final String world="World";

    public String helloWorld(){return hello +" "+ world;}
    public String helloWorld(String name){
        return  hello+" "+ name;
    }
}
