package ba.unsa.etf.rpr;

public class Korpa {
    private int kapacitet=50;
    private int velicina=0;
    private Artikl[] artikli=new Artikl[kapacitet];

    public Artikl[] getArtikli() {
        return artikli;
    }

    public Korpa(){
        velicina=0;
        artikli=new Artikl[kapacitet];
    }
    public int dajUkupnuCijenuArtikala(){
        int suma=0;
        for(int i=0;i<velicina;i++) suma+=this.artikli[i].getCijena();
        return suma;
    }
    public boolean dodajArtikl(Artikl a){
        if(velicina>=kapacitet) return  false;
        this.artikli[velicina]=new Artikl(a.getNaziv(),a.getCijena(),a.getKod());
        velicina++;
        return  true;
    }
    public Artikl izbaciArtiklSaKodom(String kod){
        Artikl artiklZaIzbaciti=new Artikl();
        for(int i=0; i<velicina; i++) {
            if(this.artikli[i].getKod().equals(kod)) {
                artiklZaIzbaciti=this.artikli[i];
                this.artikli[i] = null;
                for(int j=i;j<velicina-1;j++) {
                    this.artikli[j]=this.artikli[j+1];
                }
                this.artikli[velicina-1]=null;
                velicina--;
                break;
            }
        }
        return artiklZaIzbaciti;
    }
}
