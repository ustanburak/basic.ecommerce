package product;

import product.Impl.ReportItem;
import product.Product;

import java.util.List;

public interface ReportProduct  extends Product {
    public void addReportItem(ReportItem reportItem);
    public void setPackages(List<String> packages);
}
