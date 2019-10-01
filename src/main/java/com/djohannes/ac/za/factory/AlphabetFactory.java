package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.util.Misc;

public class AlphabetFactory
{
    public static Alphabet getAlphabet(String letter)
    {
        return new Alphabet.Builder()
                .id(Misc.generateId())
                .letter(letter)
                .build();
    }
}
