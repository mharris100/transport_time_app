package com.example.mharris.transport_time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.HashMap;

public class MainPage extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.transport_select, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        final HashMap<String, Double> speedMap = new HashMap<>();

        speedMap.put("Walking", 3.1);
        speedMap.put("Boosted Mini S Board", 18.0);
        speedMap.put("Evolve Skateboard", 26.0);
        speedMap.put("Segway i2 SE", 12.5);
        speedMap.put("Hovertrax Hoverboard", 8.0);


        Button button= (Button) findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String spinnerText = spinner.getSelectedItem().toString();


                    int distance = Integer.parseInt(((EditText) findViewById(R.id.distance)).getText().toString());


                    Double n = (distance / speedMap.get(spinnerText)) * 100;

                    String value = String.valueOf(new Double(n.intValue()) / 100 * 60);
                    System.out.println(n);
                    System.out.println(value);
                    System.out.println(value.charAt(value.length() - 1));

                    if (value.charAt(value.length() - 1) == '.') {
                        value = String.valueOf(value.subSequence(0, value.length() - 1));
                        System.out.println("asdfasdfasfasdfasdf");

                    }



                    TextView resultBox = (TextView) findViewById(R.id.result);

                    resultBox.setText(value);

                } catch (Exception e) {

                }



            }
        });

    }
}
