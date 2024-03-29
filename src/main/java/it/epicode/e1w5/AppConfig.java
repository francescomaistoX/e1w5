package it.epicode.e1w5;

import it.epicode.e1w5.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalTime;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean("funghi")
    public Topping getFunghi(){
        Topping f = new Topping();
        f.setNome("funghi");
        f.setPrezzo(0.50);
        f.setCalorie(30);
        return f;
    }
    @Bean("doppiamozzarella")
    public Topping getDoppiamozzarella(){
        Topping m = new Topping();
        m.setNome("doppiamozzarella");
        m.setPrezzo(1.50);
        m.setCalorie(100);
        return m;
    }
    @Bean("salame")
    public Topping getSalame(){
        Topping s = new Topping();
        s.setNome("salame");
        s.setPrezzo(0.80);
        s.setCalorie(80);
        return s;
    }
    @Bean("cotto")
    public Topping getCotto(){
        Topping f = new Topping();
        f.setNome("cotto");
        f.setPrezzo(0.60);
        f.setCalorie(50);
        return f;
    }
    @Bean("peperoni")
    public Topping getPeperoni(){
        Topping p = new Topping();
        p.setNome("peperoni");
        p.setPrezzo(0.50);
        p.setCalorie(40);
        return p;
    }
    @Bean("acqua")
    public Bevanda getAcqua(){
        Bevanda a = new Bevanda();
        a.setNome("acqua");
        a.setPrezzo(1.00);
        a.setCalorie(0);
        return a;
    }
    @Bean("birra")
    public Bevanda getBirra(){
        Bevanda b = new Bevanda();
        b.setNome("birra");
        b.setPrezzo(3.00);
        b.setCalorie(50);
        return b;
    }
    @Bean("coca-cola")
    public Bevanda getCoca(){
        Bevanda c = new Bevanda();
        c.setNome("coca-cola");
        c.setPrezzo(2.00);
        c.setCalorie(40);
        return c;
    }
    @Bean("Margherita")
    public PizzaBase getMargherita(){
        PizzaBase p = new PizzaBase();
        p.setNome("Margherita");
        p.setPrezzo(6.00);
        p.setCalorie(1100);
        return p;
    }
    @Bean("Diavola")
    public PizzaBase getDiavola(){
        PizzaBase p = new PizzaBase();
        p.setNome("Diavola");
        p.setPrezzo(6.50);
        p.setCalorie(1300);
        p.setToppings(List.of(getSalame()));
        return p;
    }
    @Bean("Ortolana")
    public PizzaBase getOrtolana(){
        PizzaBase p = new PizzaBase();
        p.setNome("Ortolana");
        p.setPrezzo(7.00);
        p.setCalorie(1200);
        p.setToppings(List.of(getFunghi(),getPeperoni()));
        return p;
    }
    @Bean("capricciosa")
    public PizzaBase getCapricciosa(){
        PizzaBase p = new PizzaBase();
        p.setNome("Capricciosa");
        p.setPrezzo(8.00);
        p.setCalorie(1400);
        p.setToppings(List.of(getFunghi()));
        return p;
    }
    @Bean("menu")
    public Menu getMenu(){
        Menu m = new Menu();
       m.setPizze(List.of(getMargherita(), getDiavola(), getCapricciosa(),getOrtolana()));
       m.setToppings(List.of(getFunghi(),getCotto(),getPeperoni(),getDoppiamozzarella(),getSalame()));
       m.setBevande(List.of(getAcqua(),getCoca(),getBirra()));
       return m;
    }
    @Bean("tavolo1")
   public Tavolo tavolo1(){
        Tavolo t = new Tavolo();
        t.setNumeroTavolo(1);
        t.setStato(Stato.LIBERO);
        t.setMassimonumeroCoperti(4);

        return t;

   }
   @Bean("ordine1")
   public Ordine ordine(@Value("${e1w5.coperto}")String coperto){
        Ordine o = new Ordine();
        o.setPizze(List.of(getMargherita(),getMargherita(),getDiavola()));
        o.setBevande(List.of(getCoca(),getCoca(),getBirra()));
        o.setNumeroOrdine(1);
        o.setStato(Stato.INCORSO);
        o.setNumeroCoperti(4);
        o.setCostoCoperto(Double.parseDouble(coperto));
        o.setOraAcquisizione(LocalTime.of(20,30));
        o.getImportoTotale();


        return o;


   }
}
