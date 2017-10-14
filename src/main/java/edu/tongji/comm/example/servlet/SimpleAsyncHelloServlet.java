package edu.tongji.comm.example.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenkangqiang
 * @date 2017/9/29
 *
 *
 * 异步servlet，其作用在于，一个服务器能同时处理的http请求线程是有限制的
 * 使用异步servlet后，可以及时释放HTTP请求的处理线程，从而为后续的请求提供服务器
 *
 */

//注解开启异步支持
@WebServlet(value = {"/SimpleAsyncHello"}, asyncSupported = true)
public class SimpleAsyncHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final AsyncContext asyncContext = req.startAsync();

        //调用asyncContext.start后，就可以将servlet处理线程还给servlet容器
        asyncContext.start(() -> {
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
