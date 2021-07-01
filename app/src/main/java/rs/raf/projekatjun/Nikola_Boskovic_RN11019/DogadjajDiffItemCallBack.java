package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class DogadjajDiffItemCallBack extends DiffUtil.ItemCallback<Dogadjaj> {
    @Override
    public boolean areItemsTheSame(@NonNull Dogadjaj oldItem, @NonNull Dogadjaj newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Dogadjaj oldItem, @NonNull Dogadjaj newItem) {
        return oldItem.getNazivDogadjaja().equals(newItem.getNazivDogadjaja());
    }
}
