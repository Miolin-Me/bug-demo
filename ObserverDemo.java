import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 小明用观察者模式设计了一个异步消息传递程序并期望实现消费顺序性，但结果并不理想
 * 例：小明想发“爸爸，我爱你”给他dad，但是他dad可能收到的是“我，爱你爸爸”
 * 1. 在不改变异步特性的要求下，使消息顺序得到保证
 * 2. 观察哪些地方可能造成内存泄漏，并优化它吧
 */
public class ObserverDemo {

    // 观察者
    static class Observer {
        private final String message;

        public Observer(String message) {
            this.message = message;
        }

        public void update() {
            System.out.print(message);
        }
    }

    // 主题类
    static class Subject {
        private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        private final List<Observer> observers = new ArrayList<>();

        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                executor.submit(observer::update);
            }
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new Observer("爸爸");
        Observer observer2 = new Observer("，");
        Observer observer3 = new Observer("我");
        Observer observer4 = new Observer("爱你");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);
        subject.registerObserver(observer4);

        subject.notifyObservers();
    }
}
