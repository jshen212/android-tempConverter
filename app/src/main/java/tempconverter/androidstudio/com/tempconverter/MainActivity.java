package tempconverter.androidstudio.com.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText tempEditText;
    private Button celButton;
    private Button fButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.editText);
        celButton = (Button) findViewById(R.id.cButtonId);
        fButton = (Button) findViewById(R.id.fButtonId);
        showTempTextView = (TextView) findViewById(R.id.showResultTextView);

        celButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // call convertToCelsius
                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    double intEditText = Double.parseDouble(editTextVal);
                    double convertedVal = convertToCelsius(intEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + " C");
                }
            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // call convertToFahrenheit
                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    double intEditText= Double.parseDouble(editTextVal);
                    double convertedVal = convertToFahr(intEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + " F");
                }
            }
        });
    }

    public double convertToCelsius(double farVal) {
        double resultCel;
        resultCel = (farVal - 32) * 5/9;
        return resultCel;
    }

    public double convertToFahr(double celVal) {
        double resultFahr;
        resultFahr = (celVal * 9/5) + 32;
        return resultFahr;
    }

}
