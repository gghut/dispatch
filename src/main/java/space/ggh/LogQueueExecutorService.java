package space.ggh;

import space.ggh.dispatch.QueueExecutorService;

/**
 * Created by ggh on 7/26/17.
 */
public class LogQueueExecutorService extends QueueExecutorService {

    @Override
    public int getMaxSize() {
        return 3;
    }
}
