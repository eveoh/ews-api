/**************************************************************************
 * copyright file="AsyncExecutor.java" company="Microsoft"
 *     Copyright (c) Microsoft Corporation.  All rights reserved.
 *
 * Defines the AsyncExecutor.java.
 **************************************************************************/
package microsoft.exchange.webservices.data;

import java.util.concurrent.*;

class AsyncExecutor extends ThreadPoolExecutor implements ExecutorService {

    int poolSize = 1;

    int maxPoolSize = 1;

    long keepAliveTime = 10;

    final static ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1);

    AsyncExecutor() {
        super(1, 5, 10, TimeUnit.SECONDS, queue);
    }


    public <T> Future<T> submit(Callable<T> task, AsyncCallback callback) {
        if (task == null) {
            throw new NullPointerException();
        }
        RunnableFuture<T> ftask = newTaskFor(task);
        execute(ftask);
        if (callback != null) {
            callback.setTask(ftask);
        }
        new Thread(callback).start();
        return ftask;
    }

}
