package com.company;

public class AirConditioner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("에어컨 220v On");
    }
}
