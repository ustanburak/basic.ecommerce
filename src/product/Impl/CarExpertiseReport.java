package product.Impl;

import money.Money;
import product.ReportProduct;

import java.util.List;
import java.util.Set;

public class CarExpertiseReport implements ReportProduct {

    private String name;
    private Money price;

    private List<String> packages;
    private Set<ReportItem> extraServices;

    public CarExpertiseReport(String name, Money price, Set<ReportItem> extraServices) {
        this.name = name;
        this.price = price;
        this.extraServices = extraServices;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public Money getPrice() {
        return null;
    }

    @Override
    public void addReportItem(ReportItem reportItem) {

    }

    @Override
    public void setPackages(List<String> packages) {

    }

    public List<String> getPackages() {
        return packages;
    }

    public Set<ReportItem> getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(Set<ReportItem> extraServices) {
        this.extraServices = extraServices;
    }

    @Override
    public String toString() {
        return "CarExpertiseReport{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", packages=" + packages +
                ", extraServices=" + extraServices +
                '}';
    }
}
