package org.example;

/**
 * 어떠한 타입이든 하나의 상품을 세팅 및 Get할수 있다.
 */
public class Store<T extends String> {
    T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public <R extends Integer> String objR(R r) {
        return "메소드에 R타입 쓰기";
        // 적은 코드로 똑같은일 하기
    }
}
