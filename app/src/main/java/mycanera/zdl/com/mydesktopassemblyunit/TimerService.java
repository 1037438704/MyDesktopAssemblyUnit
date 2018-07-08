package mycanera.zdl.com.mydesktopassemblyunit;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author dell-pc
 * @date 2018/7/8
 */

public class TimerService extends Service {
    private Timer timer;
    /**
     * 简单的时间格式
     * */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        //延时1秒
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateViews();
            }
        }, 0, 1000);
    }

    /**
     * 更新
     */
    private void updateViews() {
        String time = sdf.format(new Date());
        //这里是写的是xml的布局的 远程视图
        RemoteViews rv = new RemoteViews(getPackageName(), R.layout.widget);
        rv.setTextViewText(R.id.tv, time);
        //应用程序的小部件的管理器
        AppWidgetManager manager = AppWidgetManager.
                getInstance(getApplicationContext());
        //组件名称
        ComponentName cn = new ComponentName(getApplicationContext(),WidgetProvider.class);
        manager.updateAppWidget(cn,rv);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer = null;
    }
}
