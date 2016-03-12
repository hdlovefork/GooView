package com.dean.gooview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dean.gooview.ui.GooView;

public class MainActivity extends AppCompatActivity implements GooView.OnStatusChangeListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GooView goo = (GooView) findViewById(R.id.gv_goo);
        goo.setRemoveAnimation(R.drawable.anim_bubble_pop);
        goo.setText("9");
        goo.setOnStatusChangeListener(this);
    }

    @Override
    public void onRestore(GooView gooView, boolean isOutOfRange) {
        Toast.makeText(MainActivity.this, isOutOfRange ? "即使我被扯断你也不愿放手" : "怎么？舍不得我吗？", Toast.LENGTH_SHORT)
             .show();
    }

    @Override
    public void onRemove(GooView gooView) {
        Toast.makeText(MainActivity.this, "哎呦喂！小命玩完了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDragging(GooView gooView, float x, float y) {
    }

    @Override
    public void onClick(GooView gooView) {
        Toast.makeText(MainActivity.this, "不要点我嘛！", Toast.LENGTH_SHORT).show();
    }
}
