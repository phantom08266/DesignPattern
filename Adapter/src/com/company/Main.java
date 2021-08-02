package com.company;

/*
    Cleaner를 110v에 연결하려고 하였지만 Cleaner는 220v임으로 연결할 수 없다.
    즉 비슷한 속성들이지만 기기마다 지원하는 v가 다르므로 사용할 수 없게된다.
    이렇게 호환성 없는 인터페이스들 때문에 동작할 수 없는 클래스들을 사용할 수 있도록 도와주는 것이 어뎁터 패턴이다.

 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

//        Cleaner cleaner = new Cleaner();
//        connect(cleaner);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
    }

    // 110v만 수신하는 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
