package bits.timetable.timetableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       Spinner dropdown1 = (Spinner)findViewById(R.id.spinner1);
        String[] items1 = new String[]{"WS 1", "WS 2", "WS 3","WS 4","WS 5","WS 6","WS 7","WS 8","WS 9","WS 10","WS 11","WS 12","WS 13","WS 14","WS 15","WS 16","WS 17","WS 18","WS 19","WS 20","WS 21","WS 22","WS 23","WS 24"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown1.setAdapter(adapter1);

        final Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        String[] items2 = new String[]{"EG 1" ,"EG 2" ,"EG 3" ,"EG 4","EG 5","EG 6","EG 7","EG 8","EG 9","EG 10","EG 11","EG 12","EG 13","EG 14","EG 15","EG 16","EG 17","EG 18","EG 19","EG 20","EG 21","EG 22","EG 23","EG 24"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);

        RadioButton rdbtnws = (RadioButton) findViewById(R.id.rdbws);
        RadioButton rdbtneg = (RadioButton) findViewById(R.id.rdbeg);
        if(rdbtnws.isSelected())
        {
            dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(position != 0)
                        dropdown2.setVisibility(View.GONE);
                    else
                        dropdown2.setVisibility(View.VISIBLE);
                }

                public void onNothingSelected(AdapterView<?> parent) {}
            });
        }
        else if(rdbtneg.isSelected())
        {
            dropdown2.setVisibility(View.VISIBLE);
            dropdown1.setVisibility(View.INVISIBLE);


        }

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        Spinner dropdown1 = (Spinner)findViewById(R.id.spinner1);
        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);


        switch(view.getId()) {
            case R.id.rdbws:
                if (checked)
                {
dropdown1.setVisibility(View.VISIBLE);
                    dropdown2.setVisibility(View.INVISIBLE);
                }
                    break;
            case R.id.rdbeg:
                if (checked) {
                    dropdown1.setVisibility(View.GONE);
                    dropdown2.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
