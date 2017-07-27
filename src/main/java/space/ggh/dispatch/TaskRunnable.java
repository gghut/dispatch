package space.ggh.dispatch;

/**
 * Created by ggh on 7/26/17.
 */
public interface TaskRunnable {

    void run();

    void exception(Exception e);
}
