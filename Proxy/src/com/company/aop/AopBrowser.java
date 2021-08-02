package com.company.aop;

import com.company.Html;
import com.company.IBrowser;

/*
    Runnable은 FunctionalInterface 이며, 외부에서 실행할 수 있는 메서드를 주입받아 수행한다.

 */
public class AopBrowser implements IBrowser {

    private String url;
    private Html html;

    private Runnable before;
    private Runnable after;


    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();

        if (html == null){
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from "+ url);
            try {
                Thread.sleep(1000);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        after.run();

        System.out.println("AopBrowser use cache from "+ url);
        return null;
    }
}
