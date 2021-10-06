package builder;

import builder.bancos.BanrisulBuilder;
import builder.bancos.ItauBuilder;
import builder.bancos.SantanderBuilder;
import builder.gerador.GeradorDeBoleto;
import builder.interfaces.Boleto;
import builder.interfaces.BoletoBuilder;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class GeradorDeBoletoTest {

    BoletoBuilder boletoBuilderBanrisul = new BanrisulBuilder();

    BoletoBuilder boletoBuilderItau = new ItauBuilder();

    BoletoBuilder boletoBuilderSantander = new SantanderBuilder();

    @Test
    public void testaBoletoBanrisul() {
        GeradorDeBoleto geradorBanrisul = new GeradorDeBoleto(this.boletoBuilderBanrisul);
        Boleto boletoBanrisul = geradorBanrisul.gerarBoleto("Anderson Matte", "Foxter Imobiliária", 321.65D, LocalDate.now(), 789456);
        System.out.println(boletoBanrisul);
    }

    @Test
    public void testaBoletoItau() {
        GeradorDeBoleto geradorItau = new GeradorDeBoleto(this.boletoBuilderItau);
        Boleto boletoItau = geradorItau.gerarBoleto("Fernanda Praxedes Santos", "Sky", 62.99D, LocalDate.now(), 12547);
        System.out.println(boletoItau);
    }

    @Test
    public void testaBoletoSantander() {
        GeradorDeBoleto geradorSantander = new GeradorDeBoleto(this.boletoBuilderSantander);
        Boleto boletoSantander = geradorSantander.gerarBoleto("Jonas da Silva", "Lojas Colombo", 1.453, LocalDate.now(), 454546469);
        System.out.println(boletoSantander);
    }


}
