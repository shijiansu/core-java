package shijian.se05.new_util_Concurrent.Executors.FixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor extends Thread {
  private int index;

  public MyExecutor(int i) {
    this.index = i;
  }

  @Override
  public void run() {
    try {
      System.out.println("[" + this.index + "] start....");
      Thread.sleep((int) (Math.random() * 10000));
      System.out.println("[" + this.index + "] end.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String args[]) {
    // 固定线程池
    ExecutorService service = Executors.newFixedThreadPool(4);
    // 这里异步
    for (int i = 0; i < 10; i++) {
      service.execute(new MyExecutor(i));
      // service.submit(new MyExecutor(i));
    }
    System.out.println("submit finish");
    service.shutdown();
    System.out.println("程序直接打印这里");
  }
}