package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HomeWorkTest {
    HomeWork homeWork = new HomeWork();
    @Test
    void check() {
        MorseTranslator morseTranslator = homeWork.morseTranslator();
        assertEquals(("some words needs to translate to morze code").toUpperCase(),
                morseTranslator.decode(morseTranslator.encode("some words needs to translate to morze code")));
        assertEquals("... --- ... /.... --- -- . /.-- --- .-. -.- -....",
                morseTranslator.encode("SOS home work6"));
        assertEquals(morseTranslator.decode(
                "-- --- .-. ... . /- .-. .- -. ... .-.. .- - --- .-. /.... . .-.. .--. /..- -. -.. . .-. ... - .- -. -.. /.- .-.. --. --- .-. .. - .... --"),
                ("Morse Translator help understand algorithm").toUpperCase());
        assertEquals(null, morseTranslator.decode(""));
        assertEquals(null, morseTranslator.decode(null));
        assertThrows(IllegalArgumentException.class, () -> morseTranslator.decode("22!"));
        assertThrows(IllegalArgumentException.class, () -> morseTranslator.encode("wrong symbol &"));
        assertEquals(null, morseTranslator.encode(null));
        assertEquals(null, morseTranslator.encode(""));
    }


}