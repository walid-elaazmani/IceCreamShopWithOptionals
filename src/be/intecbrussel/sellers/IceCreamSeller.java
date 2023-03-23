package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;

import java.util.Optional;

public interface IceCreamSeller extends Profitable{
    
    Optional<Eatable> orderCone(Cone.Flavor[] flavorBalls);
    Optional<Eatable> orderIceRocket();
    Optional<Eatable> orderMagnum(Magnum.MagnumType type);
    
    
    
}
