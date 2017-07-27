package space.ggh.dispatch;

import java.util.concurrent.*;

/**
 * Created by ggh on 7/26/17.
 */
public abstract class QueueExecutorService extends LinkedBlockingQueue<TaskRunnable> {

    private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    private ExecutorService executorService = Executors.newFixedThreadPool(getMaxSize());

    public abstract int getMaxSize();

    public void start(int delay, int period){
        service.scheduleAtFixedRate(()->{
            try {
                TaskRunnable runnable = poll(period* 10L, TimeUnit.MILLISECONDS);
                if(runnable != null) {
                    executorService.execute(()->{
                        try {
                            runnable.run();
                        }catch (Exception e){
                            runnable.exception(e);
                        }
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, delay, period, TimeUnit.MILLISECONDS);
    }
}
