package patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class AlphabetLetter {

    private List<AlphabetLetter> alphabetLetterList;

    private String letter;

    public AlphabetLetter(){
    }

    public AlphabetLetter(String letter1){
        this.letter = letter1;
        alphabetLetterList = new ArrayList<>();
    }

    public AlphabetLetter getLetterByI(int i){
        return new AlphabetLetter(String.valueOf((char) i));
    }

    public String getLetter(){
        return letter;
    }

    public AlphabetLetter add(AlphabetLetter alphabetLetter)
    {
        alphabetLetterList.add(alphabetLetter);
        return alphabetLetter;
    }

    public List<AlphabetLetter> getAlphabetLetterList(){
        return alphabetLetterList;
    }
}
