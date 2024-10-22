package org.example;


public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Требуется реализовать интерфейс MorseTranslator в соответствии с JavaDoc описанием.
     */
    public static MorseTranslator morseTranslator() {

        return new MorseCode();
    }

    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork();
        MorseTranslator morseTranslator = homeWork.morseTranslator();
        System.out.println(morseTranslator.decode(
                "-- --- .-. ... . /- .-. .- -. ... .-.. .- - --- .-. /.... . .-.. .--. /..- -. -.. . .-. ... - .- -. -.. /.- .-.. --. --- .-. .. - .... --"));
        System.out.println(morseTranslator.encode("Morse Translator help understand algorithm"));
    }
}
