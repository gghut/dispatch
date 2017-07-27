package space.ggh;

import space.ggh.dispatch.TaskRunnable;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        LogQueueExecutorService service = new LogQueueExecutorService();
        service.start(1000, 1000);
        for (int i = 0; i< 10; i++){
            int finalI = i;
            service.put(new TaskRunnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+" -   "+new Date()+"  -   "+ finalI);
                }

                @Override
                public void exception(Exception e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println( "Hello World!" );
    }
}
