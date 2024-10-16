import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 小故事：小明用观察者模式设计了一个异步消息传递程序并期望实现消费顺序性，但结果并不理想
 * 例：小明想发“在爱奇艺看电影”到客户端，但客户端可能收到的是“爱奇艺在看电影”
 * 1. 在不改变异步特性的要求下，使消息顺序得到保证
 * 2. 观察哪些地方可能造成内存泄漏，优化它！
 */
public class ObserverDemo {
    //观察者
    static class Observer {
        private final String message;

        public Observer(String message) {
            this.message = message;
        }

        public void update() {
            System.out.print(message);
        }
    }

    //主题类 提供异步
    static class Subject {
        private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        private final List<Observer> observers = new ArrayList<>();

        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers)
                executor.submit(observer::update);
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.registerObserver(new Observer("在"));
        subject.registerObserver(new Observer("爱奇艺"));
        subject.registerObserver(new Observer("看电影"));
        subject.notifyObservers();
    }
}
