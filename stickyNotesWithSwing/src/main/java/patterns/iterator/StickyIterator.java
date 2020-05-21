package patterns.iterator;

import patterns.composite.AlphabetLetter;

import java.util.List;

public class StickyIterator implements Iterator{
    private AlphabetLetter alphabetLetter = new AlphabetLetter("A");
    private List<AlphabetLetter> alphabetLetters = alphabetLetter.getAlphabetLetterList();

    int pos;

    public StickyIterator(){
        pos = 0;
        for (int i=65; i<=90; i++) {
            AlphabetLetter alphabetLetter = new AlphabetLetter();
            alphabetLetter = alphabetLetter.getLetterByI(i);
            alphabetLetter = alphabetLetter.add(alphabetLetter);
            alphabetLetters.add(alphabetLetter);
        }
    }

    @Override
    public boolean hasNext() {
        return pos < alphabetLetters.size() &&
                alphabetLetters.get(pos) != null;
    }

    @Override
    public String next() {
        AlphabetLetter letter =  alphabetLetters.get(pos);
        pos += 1;
        return letter.getLetter();
    }

    @Override
    public String getActual() {
        return alphabetLetters.get(pos).getLetter();
    }

    @Override
    public void setPos(){
        pos = 0;
    }
}
