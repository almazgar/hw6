package org.example;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MorseCode implements MorseTranslator {
    private final Node root;
    private final Map<Character, String> morseMap;
    public MorseCode(){
        this.root = new Node();
        this.morseMap = new HashMap<>();
        initializeMorseMap();
        fillTree(morseMap);
    }

    private void fillTree(Map<Character, String> morseMap) {
        for (Map.Entry<Character, String> entry : morseMap.entrySet()) {
            String morseLetter = entry.getValue();
            Character humanLetter = entry.getKey();
            addHumanLetterTree(morseLetter, humanLetter);
        }
    }

    private void addHumanLetterTree(String morseCode, Character letter) {
        Node current = root;
        for (char symbol : morseCode.toCharArray()) {
            // если '-' то идем вправо, иначе влево
            if (symbol == '-') {
                if (current.right == null) {
                    current.right = new Node<>();
                }
                current = current.right;
            } else {
                if (current.left == null) {
                    current.left = new Node<>();
                }
                current = current.left;
            }
        }
        current.value = letter;
    }

    @Getter
    @Setter
    static class Node<E> {
        Character value;
        Node<E> left;
        Node<E> right;
    }

    private void initializeMorseMap() {
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");
        morseMap.put('0', "-----");
        morseMap.put('1', ".----");
        morseMap.put('2', "..---");
        morseMap.put('3', "...--");
        morseMap.put('4', "....-");
        morseMap.put('5', ".....");
        morseMap.put('6', "-....");
        morseMap.put('7', "--...");
        morseMap.put('8', "---..");
        morseMap.put('9', "----.");
    }
    @Override
    public String decode(String morseCode) {
        if (morseCode == null || morseCode.isEmpty()){
            return null;
        }
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = morseCode.split("/");
        for (String word : words) {
            String[] codes = word.split(" ");
            for (String code : codes) {
                char humanLetter = findHumanLetterFromTree(code);
                decodedMessage.append(humanLetter);
            }
            decodedMessage.append(" ");
        }
        return decodedMessage.toString().trim();
    }

            @Override
            public String encode (String source){
                if (source == null || source.isEmpty()){
                    return null;
                }
                StringBuilder encodedMessage = new StringBuilder();
                for (char c : source.toUpperCase().toCharArray()) {
                    if (c == ' ') {
                        encodedMessage.append("/");
                    } else {
                        String morseCode = morseMap.get(c);
                        if (morseCode != null) {
                            encodedMessage.append(morseCode).append(" ");
                        } else {
                            throw new IllegalArgumentException("Wrong Symbol !");
                        }
                    }
                }
                return encodedMessage.toString().trim();
            }

        private char findHumanLetterFromTree (String code) {
            Node current = root;
            for (char symbol : code.toCharArray()) {
                // если '-' то идем вправо, иначе влево
                if (symbol == '-' && current.right != null) {
                    current = current.right;
                } else if (symbol == '.' && current.left != null){
                    current = current.left;
                }
                else {
                    throw new IllegalArgumentException("Wrong Symbol !");
                }
            }
            return current.value;
        }
    }