package answer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ObserverAnswer {
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

    //主题类 提供异步传递消息的功能
    static class Subject {
        private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, 20, 50000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        private final List<Observer> observers = new ArrayList<>();

        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        public void unregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        public void shutDown() {
            executor.shutdown();
        }

        public void notifyObservers() {
            CompletableFuture<Void> future = CompletableFuture.completedFuture(null);
            for (Observer observer : observers) {
                future = future.thenRunAsync(observer::update);
            }
            future.join();
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new Observer("在");
        Observer observer2 = new Observer("爱奇艺");
        Observer observer3 = new Observer("看电影");
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);
        subject.notifyObservers();
        subject.unregisterObserver(observer1);
        subject.unregisterObserver(observer2);
        subject.unregisterObserver(observer3);
        subject.shutDown();
    }
}
