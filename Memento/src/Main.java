public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setName("World1");
        originator.setSize(140);
        careTaker.add(originator.saveWorld());

        originator.setName("World2");
        originator.setSize(100);
        careTaker.add(originator.saveWorld());
        System.out.println("Current World " + originator.getName() + " " + originator.getSize());
        originator.getWorldInfoFromMemento(careTaker.get(0));
        System.out.println("First world - " + originator.getName());
        originator.getWorldInfoFromMemento(careTaker.get(1));
        System.out.println("Second World - " + originator.getName());
    }
}
