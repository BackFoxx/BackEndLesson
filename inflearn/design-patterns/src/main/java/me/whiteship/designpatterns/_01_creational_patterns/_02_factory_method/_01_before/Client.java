package me.whiteship.designpatterns._01_creational_patterns._02_factory_method._01_before;

public class Client {

    public static void main(String[] args) {
        Ship whiteship = new WhiteShipFactory().orderShip("whiteShip", "keesum@gmail.com");
        System.out.println(whiteship);

        Ship blackship = new BlackShipFactory().orderShip("blackShip", "keesun@gmail.com");
        System.out.println(blackship);
    }

}
