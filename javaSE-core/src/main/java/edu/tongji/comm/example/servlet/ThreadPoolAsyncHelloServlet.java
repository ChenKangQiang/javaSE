package edu.tongji.comm.example.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenkangqiang
 * @date 2017/9/29
 */

//注解开启异步支持
@WebServlet(value = {"/ThreadPoolAsyncHello"}, asyncSupported = true)
public class ThreadPoolAsyncHelloServlet extends HttpServlet {

    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final AsyncContext asyncContext = request.startAsync();

        //用其他线程去代替servlet的容器线程
        executorService.execute(() -> {
            new LongRunningProcess().process();
            try {
                asyncContext.getResponse().getWriter().write("Hello World!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            asyncContext.complete();

        });
    }
}
