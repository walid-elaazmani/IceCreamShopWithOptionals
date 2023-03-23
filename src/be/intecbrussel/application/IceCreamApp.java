package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

import java.util.Optional;

public class IceCreamApp {
    public static void main(String[] args) {


        PriceList priceList = new PriceList(1,1,1);
        IceCreamSeller iceCreamSeller = new IceCreamSalon(priceList);

        Cone.Flavor [] flavorsOrder1 = {Cone.Flavor.BANANA, Cone.Flavor.LEMON, Cone.Flavor.MOKKA};

       Optional<Eatable> magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);

       Optional<Eatable> cone = iceCreamSeller.orderCone(flavorsOrder1);

//        IceRocket iceRocket = iceCreamSeller.orderIceRocket();

        Optional [] eatables = {magnum, cone};

        for (Optional<Eatable> eatable : eatables) {
            eatable.ifPresent(Eatable::eat);
        }

        System.out.println(iceCreamSeller.getProfit());

        






    }
}
