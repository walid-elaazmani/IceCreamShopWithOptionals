package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.Optional;

public class IceCreamCar implements IceCreamSeller {
    private PriceList priceList;

    Stock stock;
    double profit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }


    @Override
    public Optional<Eatable> orderCone(Cone.Flavor[] flavors) {
        
        Optional<Eatable> check = prepareCone(flavors);
        
        if(check.isPresent()){
             profit += priceList.getRocketprice() * flavors.length * 0.25;
        }
        
        return check;
    }

    private Optional<Eatable> prepareCone(Cone.Flavor[] flavors) {

        if (stock.getCones() <= 0 || stock.getBalls() <= 0 || flavors.length > stock.getBalls()) {
            System.out.println("No more Cones");
            return Optional.empty();
        } else {
            stock.setCones(stock.getCones() - 1);
            stock.setBalls(stock.getBalls() - flavors.length);
            return Optional.of(new Cone(flavors));
        }

    }

    @Override
    public Optional<Eatable> orderIceRocket() {
        
        Optional<Eatable> check = prepareIceRocket();
        
        if(check.isPresent()){
             profit += priceList.getRocketprice() * 0.20;
        }
        return check;
    }

    private Optional<Eatable> prepareIceRocket() {
        if (stock.getIceRockets() <= 0){
            System.out.println("No more icerockets");
            return Optional.empty();
        } else {
            stock.setIceRockets(stock.getIceRockets() - 1);
            return Optional.of(new IceRocket());
        }
    }

    @Override
    public Optional<Eatable> orderMagnum(Magnum.MagnumType type) {

        Optional<Eatable> check = prepareMagnum(type);

        if(check.isPresent()){
            profit += priceList.getMagnumPrice(type) * 0.01;
        }

        return check;
    }
   
    private Optional<Eatable> prepareMagnum(Magnum.MagnumType type) {
        if (stock.getMagni() <= 0) {
            System.out.println("No more magni");
            return Optional.empty();
        } else {
            stock.setMagni(stock.getMagni() - 1);
            return Optional.of(new Magnum(type));
        }
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
