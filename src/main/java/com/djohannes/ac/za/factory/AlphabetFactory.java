package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.domain.Evaluation;

public class AlphabetFactory
{
    public static Alphabet getAlphabet(String letter, Evaluation evaluation)
    {
        return new Alphabet.Builder()
                .letter(letter)
                .evaluation(evaluation)
                .build();
    }
}
