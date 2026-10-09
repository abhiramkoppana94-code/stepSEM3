abstract class Instrument {
Instrument() {
}

abstract String play();

}

class StringInstrument extends Instrument {

StringInstrument() {
    super();
}

@Override
String play() {
    return "Strumming the strings";
}

}

class Violin extends StringInstrument {

Violin() {
    super();
}

@Override
String play() {
    return super.play() + ", with a bow drawn across four strings";
}

}

public class Week7_violin {
public static void main(String[] args) {
StringInstrument s = new StringInstrument();
Violin v = new Violin();

    System.out.println(s.play());
    System.out.println(v.play());
}

}