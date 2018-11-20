package ca.ulaval.glo4002.cart.context;

import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;

public class ApplicationContext {
    public static final String MODE_PARAMETER = "mode";

    private ShopRepository shopRepository;

    public ApplicationContext(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void apply() {
        if (hasParameterValue(MODE_PARAMETER, "demo")) {
            new DemoPrefillContext(shopRepository).apply();
        }
    }

    private boolean hasParameterValue(String parameter, String value) {
        String property = System.getProperty(parameter);
        return property != null && property.equalsIgnoreCase(value);
    }
}
