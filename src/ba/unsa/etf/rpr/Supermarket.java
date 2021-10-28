package ba.unsa.etf.rpr;

public class Supermarket {
    private int kapacitet=1000;
    private int duzina =0;
    public Artikl[] artikli=new Artikl[kapacitet];

    public Artikl[] getArtikli() {
        return artikli;
    }
    public void dodajArtikl(Artikl a){
        if(duzina >=kapacitet) return;
        artikli[duzina++]=new Artikl(a.getNaziv(),a.getCijena(),a.getKod());
    }
    public Supermarket(){
        artikli=new Artikl[kapacitet];
        duzina =0;
    }
    public Artikl izbaciArtiklSaKodom(String kod){
        Artikl artiklZaIzbaciti=new Artikl();
        for(int i = 0; i< duzina; i++){
            if(this.artikli[i].getKod().equals(kod)){
                artiklZaIzbaciti=this.artikli[i];
                artikli[i]=null;
                for(int j = i; j< duzina -1; j++) this.artikli[j]=this.artikli[j+1];
                artikli[duzina -1]=null;
                break;
            }
        }
        duzina--;
        return  artiklZaIzbaciti;
    }
}
