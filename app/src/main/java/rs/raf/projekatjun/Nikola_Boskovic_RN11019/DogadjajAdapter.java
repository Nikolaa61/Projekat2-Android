package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.function.Function;

public class DogadjajAdapter extends ListAdapter<Dogadjaj, DogadjajAdapter.ViewHolder> {

    private final Function<Dogadjaj, Void> onDeleteClicked;
    private final Function<Dogadjaj, Void> onItemClicked;

    public DogadjajAdapter(@NonNull DiffUtil.ItemCallback<Dogadjaj> diffCallback, Function<Dogadjaj, Void> onDeleteClicked,
                           Function<Dogadjaj, Void> onItemClicked){
        super(diffCallback);
        this.onDeleteClicked = onDeleteClicked;
        this.onItemClicked = onItemClicked;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dogadjaj_list_item, parent, false);
        return new ViewHolder(view, position -> {
            Dogadjaj dogadjaj = getItem(position);
            onDeleteClicked.apply(dogadjaj);
            return null;
        },position2 ->{
            Dogadjaj dogadjaj = getItem(position2);
            onItemClicked.apply(dogadjaj);
            return null;
        });
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dogadjaj dogadjaj = getItem(position);
        holder.bind(dogadjaj);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNaziv;
        TextView tvOpis;
        TextView tvDate;
        TextView tvTime;
        TextView tvLink;
        ConstraintLayout cl;

        @RequiresApi(api = Build.VERSION_CODES.N)
        public ViewHolder(View itemView, Function<Integer, Void> onDeleteClicked, Function<Integer, Void> onItemClicked){
            super(itemView);
            tvNaziv = itemView.findViewById(R.id.tname);
            tvOpis = itemView.findViewById(R.id.topis);
            tvDate = itemView.findViewById(R.id.tdate);
            tvTime = itemView.findViewById(R.id.ttime);
            tvLink = itemView.findViewById(R.id.tlink);
            cl = itemView.findViewById(R.id.pozadina);

            ImageView iv = itemView.findViewById(R.id.delete);
            iv.setOnClickListener(v->{
                if (getAdapterPosition() != RecyclerView.NO_POSITION){
                    onDeleteClicked.apply(getAdapterPosition());
                }
            });

            itemView.setOnClickListener( v -> {
                if(getAdapterPosition() != RecyclerView.NO_POSITION){
                    onItemClicked.apply(getAdapterPosition());
                }
            });
        }

        public void bind(Dogadjaj dogadjaj){
            if (dogadjaj.getPrioritet().equals("High")){
                cl.setBackgroundColor(Color.RED);
            }else if (dogadjaj.getPrioritet().equals("Low")){
                cl.setBackgroundColor(0x50ffffff);

            }else{
                cl.setBackgroundColor(Color.GREEN);
            }

            tvNaziv.setText(dogadjaj.getNazivDogadjaja());
            tvOpis.setText(dogadjaj.getOpis());
            tvLink.setText(dogadjaj.getUrl());
            tvDate.setText(dogadjaj.getDatum());
            tvTime.setText(dogadjaj.getVreme());
        }
    }
}
