package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class AddEventActivity extends AppCompatActivity {
    private AutoCompleteTextView atvCity;
    private TimeViewModel myViewModel;
    private Button btnTimeLocation;
    private Button btnDate;
    private Button btnTime;
    private Button btnSacuvaj;
    private DatePickerDialog picker;
    private TimePickerDialog pickerTime;
    private EditText etNaziv;
    private EditText etOpis;
    private EditText etUrl;
    private Spinner prioritet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        atvCity = findViewById(R.id.autoComplete);
        btnTimeLocation = findViewById(R.id.btnCheckTime);
        btnTime = findViewById(R.id.btnSetTime);
        btnDate = findViewById(R.id.btnSetDate);
        btnSacuvaj = findViewById(R.id.btnSaveEvent);
        etNaziv = findViewById(R.id.etEventName);
        etOpis = findViewById(R.id.etDescription);
        etUrl = findViewById(R.id.etUrl);
        prioritet = findViewById(R.id.spiner);

        String[] countries = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        atvCity.setAdapter(adapter);

        myViewModel = ViewModelProviders
                .of(this)
                .get(TimeViewModel.class);

        btnTimeLocation.setOnClickListener( v ->{
            myViewModel.invokeCityService(atvCity.getText().toString());
        });

        myViewModel.getEasternStandardTime().observe(
                this,
                new Observer<TimeModel>() {
                    @Override
                    public void onChanged(TimeModel easternStandardTimeModel) {
                        btnTimeLocation.setText(easternStandardTimeModel.getDatetime());
                    }
                });

        btnDate.setOnClickListener( e ->{
            final Calendar cldr = Calendar.getInstance();
            int day = cldr.get(Calendar.DAY_OF_MONTH);
            int month = cldr.get(Calendar.MONTH);
            int year = cldr.get(Calendar.YEAR);
            // date picker dialog
            picker = new DatePickerDialog(AddEventActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            btnDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                    }, year, month, day);
            picker.show();

        });

        btnTime.setOnClickListener( e ->{
            final Calendar cldr = Calendar.getInstance();
            int hour = cldr.get(Calendar.HOUR_OF_DAY);
            int minutes = cldr.get(Calendar.MINUTE);
            // time picker dialog
            pickerTime = new TimePickerDialog(AddEventActivity.this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                            btnTime.setText("Hours: "+ sHour + ", minutes: " + sMinute);
                        }
                    }, hour, minutes, true);
            pickerTime.show();
        });

        roomDatabase();
    }

    private void roomDatabase() {
        final MyRoomDatabase myRoomDatabase = MyRoomDatabase.getDatabase(this);

        btnSacuvaj.setOnClickListener( e ->{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ///ublic Dogadjaj(String nazivDogadjaja, String opis, String datum, String vreme, String grad, String prioritet, String url) {

                    Dogadjaj dogadjaj = new Dogadjaj(etNaziv.getText().toString(), etOpis.getText().toString(), btnDate.getText().toString(), btnTime.getText().toString(),
                            atvCity.getText().toString(), prioritet.getSelectedItem().toString(), etUrl.getText().toString());
                    long personId = myRoomDatabase.dogadjajDao().insert(dogadjaj);
                }
            }).start();
        });
    }
}