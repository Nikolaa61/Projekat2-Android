package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ShowEventsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DogadjajViewModel dogadjajViewModel;
    private DogadjajAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_events);

        recyclerView = findViewById(R.id.listRvRashodi);

        dogadjajViewModel = ViewModelProviders.of(this).get(DogadjajViewModel.class);


        adapter = new DogadjajAdapter(new DogadjajDiffItemCallBack(), dogadjaj -> {
            dogadjajViewModel.removeDogadjaj(dogadjaj);
            return null;
        }, dogadjaj1 -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);

            String titleAndContent=dogadjaj1.getNazivDogadjaja()+"\n"+ dogadjaj1.getDatum()+"\n"+
                    dogadjaj1.getVreme()+"\n"+dogadjaj1.getOpis()+"\n"+dogadjaj1.getGrad()+"\n"+
                    dogadjaj1.getPrioritet()+"\n"+ dogadjaj1.getUrl();

            intent.putExtra(Intent.EXTRA_TEXT, titleAndContent);
            intent.setType("text/plain");
            Intent newIntent = Intent.createChooser(
                    intent, "Share");
            startActivity(newIntent);
            return null;
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);




        dogadjajViewModel.getSviDogadjaji().observe(this, new Observer<List<Dogadjaj>>() {
            @Override
            public void onChanged(List<Dogadjaj> dogadjajs) {
                adapter.submitList(dogadjajs);
            }
        });

    }




}