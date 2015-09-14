package fi.ptm.datatransferbetweenactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by PTM on 14/09/15.
 */
public class CalcActivity extends Activity {

    private double one, two, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        // get data from calling intent
        Bundle extras = getIntent().getExtras();
        one = extras.getDouble("one");
        two = extras.getDouble("two");

    }

    public void addClicked(View view) {
        result = one + two;
        calcDone();
    }

    public void multiplyClicked(View view) {
        result = one * two;
        calcDone();
    }


    public void substractClicked(View view) {
        result = one - two;
        calcDone();
    }

    public void divideClicked(View view) {
        result = one / two;
        calcDone();
    }


    private void calcDone() {
        // create a new intent to pass data
        Intent intent = new Intent();
        // add result to intent
        intent.putExtra("result", result);
        // all ok here, result is set
        setResult(RESULT_OK,intent);
        // close this activity
        finish();
    }


}

