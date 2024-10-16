package answer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SingletonAnswer {
    private static volatile SingletonAnswer instance;
    private List<WeakReference<Listener>> listeners = new ArrayList<>();
    private SingletonAnswer() {}

    public static SingletonAnswer getInstance() {
        if (instance == null) {
            synchronized (SingletonAnswer.class) {
                if (instance == null)
                    instance = new SingletonAnswer();
            }
        }
        return instance;
    }

    public void addListener(Listener listener) {
        listeners.add(new WeakReference<>(listener));
    }

    static class Listener {
        private byte[] memory = new byte[1024 * 1024];
    }
}
