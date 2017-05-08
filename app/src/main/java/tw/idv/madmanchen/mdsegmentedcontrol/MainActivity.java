package tw.idv.madmanchen.mdsegmentedcontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import tw.idv.madmanchen.mdsegmentedcontrollib.MDSegmentedControl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MDSegmentedControl sc = (MDSegmentedControl) findViewById(R.id.sc);
        sc.setOnChoiceListener(new MDSegmentedControl.OnChoiceListener() {
            @Override
            public void onChoice(View view, int pos) {
                Log.e("pos", pos + "");
            }
        });
        sc.setChoice(2);
    }
}
