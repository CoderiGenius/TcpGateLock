import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * 废弃类
 */
public class TestTimer {
    static Timer timer = new Timer();
    public static void main(String[] args){
    timer1();

    }
    public static void timer1() {
        //Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("未在规定时间收到心跳包，socket重置");
                try {
                    StartSocket.CloseSource();
                    StartSocket.StratListening(1028);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }, 20000);//
    }

}
