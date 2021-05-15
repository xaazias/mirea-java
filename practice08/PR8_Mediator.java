package ru.mirea.java.practice08;

/*
    Mediator :It defines the interface for communication between colleague objects.
    ConcreteMediator : It implements the mediator interface and coordinates communication between colleague objects.
    Colleague : It defines the interface for communication with other colleagues
    ConcreteColleague : It implements the colleague interface and communicates with other colleagues through its mediator
*/

class AirTrafficControllerMediator implements AirTrafficControllerMediatorInterface {
    private Flight flight;
    private Runway runway;
    public boolean land;

    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    public void registerFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isLandingOk() {
        return land;
    }

    @Override
    public void setLandingStatus(boolean status) {
        land = status;
    }
}

interface Command {
    void land();
}

interface AirTrafficControllerMediatorInterface {

    public void registerRunway(Runway runway);

    public void registerFlight(Flight flight);

    public boolean isLandingOk();

    public void setLandingStatus(boolean status);
}

class Flight implements Command {
    private AirTrafficControllerMediatorInterface atcMediator;

    public Flight(AirTrafficControllerMediatorInterface atcMediator) {
        this.atcMediator = atcMediator;
    }

    public void land() {
        if (atcMediator.isLandingOk()) {
            System.out.println("Успешно приземлились.");
            atcMediator.setLandingStatus(true);
        } else
            System.out.println("Ожидание посадки.");
    }

    public void getReady() {
        System.out.println("Готов для посадки.");
    }

}

class Runway implements Command {
    private AirTrafficControllerMediatorInterface atcMediator;

    public Runway(AirTrafficControllerMediatorInterface atcMediator) {
        this.atcMediator = atcMediator;
        atcMediator.setLandingStatus(true);
    }

    @Override
    public void land() {
        System.out.println("Разрешение на посадку получено.");
        atcMediator.setLandingStatus(true);
    }

}

class MediatorDesignPattern {
    public static void main(String args[]) {

        AirTrafficControllerMediatorInterface atcMediator = new AirTrafficControllerMediator();
        Flight flight01 = new Flight(atcMediator);
        Runway mainRunway = new Runway(atcMediator);
        atcMediator.registerFlight(flight01);
        atcMediator.registerRunway(mainRunway);
        flight01.getReady();
        mainRunway.land();
        flight01.land();
    }
}
