package thread;

// 主线程
public class Main {
    public static void main(String[] args) {
        // 创建一个子线程
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // 子线程执行任务
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("子线程正在运行...");
                        // 模拟耗时操作
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    // 捕获到中断异常，说明被主线程中断了
                    System.out.println("子线程被中断了！");
                   e.printStackTrace();
                }
            }
        });
        // 启动子线程
        t.start();
        // 主线程等待3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 主线程向子线程发送中断请求
        t.interrupt();
    }
}