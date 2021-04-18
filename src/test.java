import java.util.List;

public class test {

    public static int priceCheck(List<String> products, List<Float> productPrices,
                                 List<String> productSold, List<Float> soldPrice) {
        int incorect = 0;
        for (int i = 0; i < productSold.size(); i++) {
            float priceS = soldPrice.get(i);
            float price = 0;

            for (int j = 0; j < products.size(); j++) {
                if (products.get(j).equals(productSold.get(i))) {
                    price = productPrices.get(j);
                    break;
                }
            }
            if (price != priceS) {
                incorect++;
            }
        }
        return incorect;
    }

}
