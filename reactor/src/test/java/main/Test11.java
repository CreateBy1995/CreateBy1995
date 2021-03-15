package main;

import javax.annotation.processing.Completion;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-21
 **/
public class Test11 {
    private CompletableFuture<T> uniWhenCompleteStage(
            Executor e, BiConsumer<? super T, ? super Throwable> f) {
        // 创建一个CompletableFuture表示
        CompletableFuture<T> d = new CompletableFuture<T>();
        // e表示执行的线程池，如果是同步，e为null
        // uniWhenComplete方法中回去判断当前任务是否已经有结果，如果有结果就会直接触发action
        // 否则将action压入栈中,因为whenComplete方法可以在future完成前后调用
        // 如果是在完成前调用，那么在future完成后会去将栈中所有的action弹出并且执行
        // 如果是在完成后调用, 那么在uniWhenComplete方法中直接就会去执行action
        if (e != null || !d.uniWhenComplete(this, f, null)) {
            // UniWhenComplete表示一个在CompletableFuture完成时会执行的action
            CompletableFuture.UniWhenComplete<T> c = new CompletableFuture.UniWhenComplete<T>(e, d, this, f);
            // 将待执行的action压入栈中
            push(c);
            // 尝试触发动作，会去判断CompletableFuture是否已经执行完成，如果完成的话就会去触发相关动作
            c.tryFire(SYNC);
        }
        return d;
    }
    final void postComplete() {
        CompletableFuture<?> f = this; Completion h;
        while ((h = f.stack) != null ||
                (f != this && (h = (f = this).stack) != null)) {
            CompletableFuture<?> d; Completion t;
            if (f.casStack(h, t = h.next)) {
                if (t != null) {
                    if (f != this) {
                        pushStack(h);
                        continue;
                    }
                    h.next = null;    // detach
                }
                f = (d = h.tryFire(NESTED)) == null ? this : d;
            }
        }
    }
}
