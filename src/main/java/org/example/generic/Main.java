package org.example.generic;

public class Main {
    public static void main(String[] args) {

        Store<String> store = new Store<>();

//        Store<Integer> store1 = new Store<>();

        store.setObj("ABC");
//        store1.setObj(123);

        System.out.println(store.getObj());
//        System.out.println(store1.getObj());
    }
}