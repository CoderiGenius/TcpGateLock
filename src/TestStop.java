import java.util.Timer;
import java.util.TimerTask;

/**
 * 废弃类
 */

public class TestStop {
    static final Timer timer = new Timer();
    static TimerTask task = null;
    public static void main(String[] args) {
            test();
            //TestStop.timer.cancel();
    }

    public static void test(){
    task = new TimerTask() {
        private int count;

        @Override
        public void run() {
            this.count++;
            System.out.println(count);
            if (count == 10) {
                task.cancel();
                //System.out.println("定时器停止了");
                //timer.cancel();// 停止定时器
            }
        }
    };
        timer.schedule(task,0,1000);// 1秒一次
}
}
