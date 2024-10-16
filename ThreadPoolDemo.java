import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 工作中我们也许需要使用线程池复用线程来减少创建较大对象或较长任务所产生的性能开销
 * 下列模拟一个线程池的使用场景，由于任务量大，执行时长足够长，可能产生一定的bug
 * 请优化example中线程池的使用
 */
public class ThreadPoolDemo {

    static class Task implements Runnable {

        int id;

        Task(final int id) {
            this.id = id;
        }

        @Override
        public void run() {
            //假设单个任务执行完成需要10s
            try {
                System.out.println(Thread.currentThread().getName() + " && Thread id : " + id);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void example(long loop) {
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100000000; i++) {
            pool.execute(new Task(i));
        }
    }

    public static void main(String[] args) {
        //假设有3亿次任务需要执行
        int task_number = 300000000;
        example(task_number);
    }
}
