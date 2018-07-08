package mycanera.zdl.com.mydesktopassemblyunit;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

/**
 * @author dell-pc
 * @date 2018/7/8
 */

public class WidgetProvider extends AppWidgetProvider {
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        //最后一个widget被从屏幕移除执行
        context.stopService(new Intent(context,TimerService.class));
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        //第一个widget添加到屏幕上执行
        context.startService(new Intent(context,TimerService.class));
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        //刷新widget
        //remoteView和AppWidgetManager
    }
}
