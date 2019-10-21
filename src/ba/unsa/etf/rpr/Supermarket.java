package ba.unsa.etf.rpr;

public class Supermarket {
    private int kapacitet=1000;
    private int velicina=0;
    public Artikl[] artikli=new Artikl[kapacitet];

    public Artikl[] getArtikli() {
        return artikli;
    }
    public void dodajArtikl(Artikl a){
        if(velicina>=kapacitet) return;
        artikli[velicina++]=new Artikl(a.getNaziv(),a.getCijena(),a.getKod());
    }
    public Supermarket(){
        artikli=new Artikl[kapacitet];
        velicina=0;
    }
    public Artikl izbaciArtiklSaKodom(String kod){
        Artikl artiklZaIzbaciti=new Artikl();
        for(int i=0;i<velicina;i++){
            if(this.artikli[i].getKod().equals(kod)){
                artiklZaIzbaciti=this.artikli[i];
                artikli[i]=null;
                for(int j=i;j<velicina-1;j++) this.artikli[j]=this.artikli[j+1];
                artikli[velicina-1]=null;
                break;
            }
        }velicina--;
        return  artiklZaIzbaciti;
    }
}
