import basket.BasketItem;
import basket.BasketType;
import basketitem.builder.BasketItemBuilder;
import money.Currency;
import money.Money;
import payment.ClassifiedPaymentIntegrator;
import payment.ExpertiseReportPaymentIntegrator;
import payment.PaymentIntegrator;
import payment.provider.PaymentProvider;
import payment.provider.model.AssecoPaymentProvider;
import payment.provider.model.IyzicoPaymentProvider;
import payment.provider.model.PreviousPayment;
import product.ClassifiedProduct;
import product.Impl.CarExpertiseReport;
import product.Impl.Classified;
import product.Impl.Doping;
import product.Impl.ReportItem;
import product.Impl.type.DopingType;
import product.ReportProduct;
import shoppingchart.ShoppingChart;
import tax.calculator.KDVTaxCalculator;
import tax.calculator.OTVTaxCalculator;
import tax.calculator.TaxCalculator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Doping> dopings = new HashSet<Doping>();
        dopings.add(new Doping("Güncelim Dopingi", new Money(100, Currency.TL), DopingType.UptoDate));
        ClassifiedProduct classified = new Classified("Araç ilanı", new Money(100000, Currency.TL), dopings);
        ((Classified)classified).setTitle("Sıfır araç temiz!");
        ((Classified)classified).setDescription("ALKKJFALSJLKDAJLSKJLAK JLAKSJLDA");


        Set<ReportItem> extraServices = new HashSet<ReportItem>();
        extraServices.add(new ReportItem("Vale hizmeti", new Money(50, Currency.TL)));
        extraServices.add(new ReportItem("Araç yıkama hizmeti", new Money(100, Currency.TL)));
        ReportProduct expertiseReport = new CarExpertiseReport("Otomobil Ekspertiz Raporu", new Money(200, Currency.TL), extraServices);


        List<TaxCalculator> taxCalculatorForClassified = Arrays.asList(new KDVTaxCalculator(), new OTVTaxCalculator());
        BasketItem classifiedbasketItem = BasketItemBuilder.buildBasketItem(classified, taxCalculatorForClassified, BasketType.Classified);

        List<TaxCalculator> taxCalculatorForExpertiseReport = Arrays.asList(new OTVTaxCalculator());
        BasketItem expertiseReportbasketItem = BasketItemBuilder.buildBasketItem(expertiseReport, taxCalculatorForExpertiseReport, BasketType.CarExpertiseReport);


        ShoppingChart shoppingChart = new ShoppingChart(new ArrayList<BasketItem>());
        shoppingChart.addBasketItem(classifiedbasketItem);
        shoppingChart.addBasketItem(expertiseReportbasketItem);

        System.out.println("Alışveriş Sepetimiz");
        printShoppingChart(shoppingChart);



        PaymentProvider iyzico = new IyzicoPaymentProvider(new HashMap<Integer, PreviousPayment>());
        PaymentProvider asseco = new AssecoPaymentProvider(new HashMap<Integer, PreviousPayment>());

        PaymentIntegrator classifiedIntegrator = new ClassifiedPaymentIntegrator(asseco, BasketType.Classified);
        PaymentIntegrator expertiseIntegrator = new ExpertiseReportPaymentIntegrator(BasketType.CarExpertiseReport, iyzico);

        int chargeIdForClassified = classifiedIntegrator.makePayment(shoppingChart);
        int chargeIdForExpertiseReport = expertiseIntegrator.makePayment(shoppingChart);

        System.out.println("Ödenmiş Faturalar");
        System.out.println(asseco.loadInvoice(chargeIdForClassified));
        System.out.println(iyzico.loadInvoice(chargeIdForExpertiseReport));

    }

    private static void printShoppingChart(ShoppingChart shoppingChart) {

        for(BasketItem basketItem : shoppingChart.getBasketItemList()) {
            System.out.println(basketItem);
        }

        System.out.println();
    }
    }

