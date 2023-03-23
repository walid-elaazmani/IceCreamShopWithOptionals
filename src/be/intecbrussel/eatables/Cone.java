package be.intecbrussel.eatables;

public class Cone implements Eatable{
    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRATCIATELLE,
        MOKKA,
        PISTACHE;
    }

    Flavor[] balls;

    public Cone() {
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {

        System.out.print("Cone flavors: ");

        for (Flavor ball : balls) {
            System.out.print(ball.name() + " ");
        }

        System.out.println();

    }
}
