package edu.tongji.comm.example.servlet.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

/**
 * @author chenkangqiang
 * @date 2017/9/29
 */

@Controller
public class AsyncDeferredController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncDeferredController.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/deferred", method = RequestMethod.GET, produces = "text/html")
    public DeferredResult<String> executeSlowTask() {
        logger.info("Request received");
        final DeferredResult<String> deferredResult = new DeferredResult<>();

        CompletableFuture.supplyAsync(taskService::execute)
                .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));

        logger.info("Servlet thread released");

        return deferredResult;
    }
}
