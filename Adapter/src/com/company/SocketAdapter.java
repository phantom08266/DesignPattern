package com.company;

/*
    SocketAdapter의 역할은 우린 결국 v220도 v110에서 사용할 수 있도록 하려는 것이 목적임으로 v110를 implements하여 구현한다.
    당연히 v220를 v110로 변환해야하기 때문에 v220를 주입받아야 한다.
 */


public class SocketAdapter implements Electronic110V{

    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V){
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
