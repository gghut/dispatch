package space.ggh.dispatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ggh on 7/26/17.
 */
public abstract class TaskExecutorService implements AutoCloseable, Runnable {

    private ExecutorService executorService = Executors.newFixedThreadPool(getMaxSize());

    public abstract int getMaxSize();

    public void execute(TaskRunnable runnable){
        executorService.execute(() -> {
            try {
                runnable.run();
            }catch (Exception e){
                runnable.exception(e);
            }
        });
    }

    public void execute(){
        executorService.execute(this);
    }

    @Override
    public void run(){

    }

    public void close() throws Exception {
        executorService.shutdown();
    }
}
