package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dogadjaji")
public class Dogadjaj {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String nazivDogadjaja;
    private String opis;
    private String datum;
    private String vreme;
    private String grad;
    private String prioritet;
    private String url;

    public Dogadjaj(String nazivDogadjaja, String opis, String datum, String vreme, String grad, String prioritet, String url) {
        this.nazivDogadjaja = nazivDogadjaja;
        this.opis = opis;
        this.datum = datum;
        this.vreme = vreme;
        this.grad = grad;
        this.prioritet = prioritet;
        this.url = url;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNazivDogadjaja(String nazivDogadjaja) {
        this.nazivDogadjaja = nazivDogadjaja;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public void setPrioritet(String prioritet) {
        this.prioritet = prioritet;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNazivDogadjaja() {
        return nazivDogadjaja;
    }

    public String getOpis() {
        return opis;
    }

    public String getDatum() {
        return datum;
    }

    public String getVreme() {
        return vreme;
    }

    public String getGrad() {
        return grad;
    }

    public String getPrioritet() {
        return prioritet;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Dogadjaj{" +
                "id=" + id +
                ", nazivDogadjaja='" + nazivDogadjaja + '\'' +
                ", opis='" + opis + '\'' +
                ", datum='" + datum + '\'' +
                ", vreme='" + vreme + '\'' +
                ", grad='" + grad + '\'' +
                ", prioritet='" + prioritet + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
