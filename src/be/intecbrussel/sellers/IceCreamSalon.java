package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.Optional;

public class IceCreamSalon implements IceCreamSeller{
    private PriceList priceList;
    private double totalProfit;


    public IceCreamSalon(PriceList priceList) {
        this.totalProfit = 0;
        this.priceList = priceList;
    }

    @Override
    public Optional<Eatable> orderCone(Cone.Flavor[] flavors) {
        Cone cone = new Cone(flavors);
        totalProfit += priceList.getBallprice() * flavors.length * 0.25;
        return Optional.of(cone);
    }

    @Override
    public Optional<Eatable> orderIceRocket() {
        IceRocket icerocket = new IceRocket();
        totalProfit += priceList.getRocketprice() * 0.20;
        return Optional.of(icerocket);
    }

    @Override
    public Optional<Eatable> orderMagnum(Magnum.MagnumType type) {
        Magnum magnum = new Magnum(type);
        totalProfit += priceList.getMagnumPrice(type)* 0.01;
        return Optional.of(magnum);
    }


    @Override
    public double getProfit() {
        return totalProfit;
    }
}
