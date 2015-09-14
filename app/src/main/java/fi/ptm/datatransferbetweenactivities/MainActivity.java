package fi.ptm.datatransferbetweenactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by PTM on 14/09/15.
 */
public class MainActivity extends Activity {

    private EditText numberone_text;
    private EditText numbertwo_text;
    private final int SHOW_CALCULATE_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find id's
        numberone_text = (EditText) findViewById(R.id.numberone_txt);
        numbertwo_text = (EditText) findViewById(R.id.numbertwo_txt);
    }

    public void calcButtonClicked(View view) {
        String numberOne = numberone_text.getText().toString();
        String numberTwo = numbertwo_text.getText().toString();
        double one = Double.parseDouble(numberOne);
        double two = Double.parseDouble(numberTwo);
        Intent intent = new Intent(MainActivity.this, CalcActivity.class);
        intent.putExtra("one", one);
        intent.putExtra("two", two);
        startActivityForResult(intent, SHOW_CALCULATE_ACTIVITY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case SHOW_CALCULATE_ACTIVITY:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle extras = data.getExtras();
                    double result = extras.getDouble("result");
                    TextView tv = (TextView) findViewById(R.id.resultTextView);
                    tv.setText("Result: "+result);
                }
                break;
        }
    }

}
