package me.whiteship.designpatterns._01_creational_patterns._02_factory_method._01_before;

public class WhiteShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
