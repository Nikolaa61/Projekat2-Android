package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAddEvent;
    private Button btnShowEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowEvents = findViewById(R.id.btnShowEvent);
        btnAddEvent = findViewById(R.id.btnAddEvent);

        btnAddEvent.setOnClickListener( v -> {
            Intent intent = new Intent(this, AddEventActivity.class);
            startActivity(intent);
        });

        btnShowEvents.setOnClickListener( v -> {
            Intent intent = new Intent(this, ShowEventsActivity.class);
            startActivity(intent);
        });
    }


}