package at.trinkl.daniel.berechnung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input2 = (EditText) findViewById(R.id.userInput);
                if (input2.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Keine Eingabe", Toast.LENGTH_SHORT).show();
                } else {
                    final double input = Double.parseDouble(((EditText) findViewById(R.id.userInput)).getText().toString().replace(",", "."));
                    final double fa = Double.parseDouble(((Spinner) findViewById(R.id.count)).getSelectedItem().toString());
                    if (input == 0) {
                        Toast.makeText(MainActivity.this, "Ungültige Eingabe", Toast.LENGTH_SHORT).show();
                    } else {
                        Calculation calculation = new Calculation();
                        double dole = calculation.calculate(input, fa);
                        ((TextView) findViewById(R.id.result)).setText("Ihr tägliches Arbeitslosengeld beträgt: € " + dole);
                    }
                }
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.count);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kinder_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}