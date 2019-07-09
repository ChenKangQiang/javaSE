package edu.tongji.comm.example.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-01-22
 */
public class RxJavaMain {

    public static void main(String[] args) {

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                System.out.println("Observable emit 1" + "\n");
                emitter.onNext(1);
                System.out.println("Observable emit 2" + "\n");
                emitter.onNext(2);
                System.out.println("Observable emit 3" + "\n");
                emitter.onNext(3);
                System.out.println("Observable emit 4" + "\n");
                emitter.onNext(4);
            }
        }).map(new Function<Object, Object>() {
            @Override
            public Object apply(Object o) throws Exception {
                return null;
            }
        }).subscribe(new Observer<Object>() {

            private int i;
            private Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) {
                this.disposable = d;
            }

            @Override
            public void onNext(Object o) {
                i++;
                if (i == 2) {
                    //在RxJava 2.x中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    disposable.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete" + "\n");
            }
        });
    }

}
