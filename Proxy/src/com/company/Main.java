package com.company;

import com.company.aop.AopBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        // write your code here

        /*
            일반적으로 proxy를 사용하지 않으면 로딩을 호출갯수만큼 하게된다.
            이렇게 사용해도 별 문제는 없지만 추후 호출할때마다 로딩을 하는 것을 볼 수 있다.
         */
//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();

        /*
            그래서 Proxy를 사용하여 한번만 로딩하고 그다음부터는 캐시된 데이터를 사용하도록 흐름을 제어할 수 있다.
            이때 주의할 점은 값을 변경하는 것이 아니라 흐름을 변경하는 것이다.

            즉 BrowserProxy를 사용하여 해당 일을 대신 처리하게 한다.
         */
//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();

        /*
            스프링에서 aop를 프록시 패턴을 사용하여 구현하고 있다.
            이를 모방하자면 browser 로딩 시간이 1초가 걸리기 때문에 캐시에 저장 후 이후 요청에서는 캐시에서 가져오니깐 로딩 시간이 0인 것을 알 수 있다.
            이렇게 특정 메서드의 전,후에 처리를 할 수 있도록 도와주어 핵심로직과 부가로직을 분리시키는 것이 aop이다.
         */
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
    }

}
