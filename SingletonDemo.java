import java.util.ArrayList;
import java.util.List;

/**
 * 检查单例模式编写的正确性 并为防止可能产生的bug进行优化
 */
public class SingletonDemo {
    private static SingletonDemo instance;
    private List<Listener> listeners = new ArrayList<Listener>();

    private SingletonDemo() {}

    public static SingletonDemo getInstance() {
        synchronized (SingletonDemo.class) {
            if (instance == null) {
                instance = new SingletonDemo();
            }
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
