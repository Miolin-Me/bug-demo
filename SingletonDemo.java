import java.util.ArrayList;
import java.util.List;

/**
 * 1. 修改单例模式保证线程安全
 * 2. 优化代码以防止可能产生的内存泄漏问题
 */
public class SingletonDemo {
    private static SingletonDemo instance;
    private List<Listener> listeners = new ArrayList<Listener>();
    private SingletonDemo() {}

    public static SingletonDemo getInstance() {
        synchronized (SingletonDemo.class) {
            if (instance == null)
                instance = new SingletonDemo();
        }
        return instance;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    static class Listener {
        private byte[] memory = new byte[1024 * 1024];
    }
}
