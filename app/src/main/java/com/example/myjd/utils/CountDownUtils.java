package com.example.myjd.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by libo on 2018/2/25.
 */

public class CountDownUtils {
    private long day = 0;
    private long hour = 0;
    private long minute = 0;
    private long second = 0;

    private boolean dayNotAlready = false;
    private boolean hourNotAlready = false;
    private boolean minuteNotAlready = false;
    private boolean secondNotAlready = false;
    private TextView textView;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            textView.setText(getCurDuration());
        }
    };

    public CountDownUtils(long totalSeconds, TextView textView){
        this.textView = textView;
        initData(totalSeconds);
    }

    public void startCount() {
        new Timer().schedule(new TimerTask() {
            public void run() {
                if (secondNotAlready) {
                    handler.sendEmptyMessage(0);
                } else {
                    cancel();
                }

            }
        }, 0, 1000);
    }

    /**
     * 初始化赋值
     *
     * @param totalSeconds
     */
    private void initData(long totalSeconds) {
        resetData();

        if (totalSeconds > 0) {
            secondNotAlready = true;
            second = totalSeconds;
            if (second >= 60) {
                minuteNotAlready = true;
                minute = second / 60;
                second = second % 60;
                if (minute >= 60) {
                    hourNotAlready = true;
                    hour = minute / 60;
                    minute = minute % 60;
                    if (hour > 24) {
                        dayNotAlready = true;
                        day = hour / 24;
                        hour = hour % 24;
                    }
                }
            }
        }
    }

    private void resetData() {
        day = 0;
        hour = 0;
        minute = 0;
        second = 0;
        dayNotAlready = false;
        hourNotAlready = false;
        minuteNotAlready = false;
        secondNotAlready = false;
    }

    /**
     * 计算各个值的变动
     *
     */
    public String getCurDuration() {
        if (secondNotAlready) {
            if (second > 0) {
                second--;
                if (second == 0 && !minuteNotAlready) {
                    secondNotAlready = false;
                }
            } else {
                if (minuteNotAlready) {
                    if (minute > 0) {
                        minute--;
                        second = 59;
                        if (minute == 0 && !hourNotAlready) {
                            minuteNotAlready = false;
                        }

                    } else {
                        if (hourNotAlready) {
                            if (hour > 0) {
                                hour--;
                                minute = 59;
                                second = 59;
                                if (hour == 0 && !dayNotAlready) {
                                    hourNotAlready = false;
                                }

                            } else {
                                if (dayNotAlready) {
                                    day--;
                                    hour = 23;
                                    minute = 59;
                                    second = 59;
                                    if (day == 0) {
                                        dayNotAlready = false;
                                    }

                                }
                            }
                        }
                    }

                }
            }

        }

        return hour + ":" + minute + ":" + second;
    }

}