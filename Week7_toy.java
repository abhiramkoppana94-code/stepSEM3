abstract class Toy {
private static int counter = 1000;
private final String toyId;
protected String name;

Toy(String name) {
    this.name = name;
    counter++;
    toyId = "TOY-" + counter;
}

abstract String makeSound();

String getToyId() {
    return toyId;
}

}

class ToyCar extends Toy {
ToyCar(String name) {
super(name);
}

@Override
String makeSound() {
    return name + ": Vroom vroom!";
}

}

class ToyRobot extends Toy {
ToyRobot(String name) {
super(name);
}

@Override
String makeSound() {
    return name + ": Beep boop!";
}

}

public class Week7_toy {
public static void main(String[] args) {
ToyCar c = new ToyCar("Speedster");
ToyRobot r = new ToyRobot("Bolt");

    System.out.println(c.makeSound());
    System.out.println(r.makeSound());

    System.out.println(c.getToyId());
    System.out.println(r.getToyId());
}

}