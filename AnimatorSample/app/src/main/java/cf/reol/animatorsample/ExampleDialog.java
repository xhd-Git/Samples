package cf.reol.animatorsample;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by reol on 2017/12/1.
 */

public class ExampleDialog extends Dialog{

    public ExampleDialog(@NonNull Activity context) {
        super(context);

        View view = new ImageView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;
        view.setLayoutParams(params);
        view.setBackgroundColor(Color.BLUE);
        Window window = this.getWindow();
        if (window != null){
            window.requestFeature(Window.FEATURE_NO_TITLE);
        }
        setContentView(view);
        if (window != null) {
            window.setWindowAnimations(R.style.ExampleDialog);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.getAttributes().gravity = Gravity.CENTER;
            window.setDimAmount(0.75f);
            WindowManager.LayoutParams wl = window.getAttributes();
            DisplayMetrics metrics = new DisplayMetrics();
            context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            wl.width = metrics.widthPixels / 13 * 12;
            wl.height = metrics.heightPixels / 5 * 4;
        }
    }
}
