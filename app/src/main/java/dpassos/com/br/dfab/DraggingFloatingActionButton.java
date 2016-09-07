package dpassos.com.br.dfab;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by djalma on 06/09/2016.
 * Long Click Action enables dragging the button.
 */
public class DraggingFloatingActionButton extends FloatingActionButton {

    public DraggingFloatingActionButton(Context context) {
        super(context);
        init();
    }

    public DraggingFloatingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DraggingFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setOnTouchListener(scroolableTouchListener);
                return true;
            }
        });
    }

    View.OnTouchListener scroolableTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                setX((event.getRawX() - v.getWidth()));
                setY((event.getRawY() - v.getHeight()));
                return true;
            } else {
                return false;
            }
        }
    };
}