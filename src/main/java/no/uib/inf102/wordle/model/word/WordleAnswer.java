package no.uib.inf102.wordle.model.word;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import no.uib.inf102.wordle.model.Dictionary;

/**
 * This class represents an answer to a Wordle puzzle.
 * 
 * The answer must be one of the words in the LEGAL_WORDLE_LIST.
 */
public class WordleAnswer {

    private final String WORD;

    private Dictionary dictionary;

    private static Random random = new Random();

    /**
     * Creates a WordleAnswer object with a random word from the answer word list
     */
    public WordleAnswer(Dictionary dictionary) {
        this(random, dictionary);
    }

    /**
     * Creates a WordleAnswer object with a random word from the answer word list
     * using a specified random object.
     * This gives us the opportunity to set a seed so that tests are repeatable.
     */
    public WordleAnswer(Random random, Dictionary dictionary) {
        this(getRandomWordleAnswer(random, dictionary), dictionary);
    }

    /**
     * Creates a WordleAnswer object with a given word.
     * 
     * @param answer
     */
    public WordleAnswer(String answer, Dictionary dictionary) {
        this.WORD = answer.toLowerCase();
        this.dictionary = dictionary;
    }

    /**
     * Gets a random wordle answer
     * 
     * @param random
     * @return
     */
    private static String getRandomWordleAnswer(Random random, Dictionary dictionary) {
        List<String> possibleAnswerWords = dictionary.getAnswerWordsList();
        int randomIndex = random.nextInt(possibleAnswerWords.size());
        String newWord = possibleAnswerWords.get(randomIndex);
        return newWord;
    }

    /**
     * Guess the Wordle answer. Checks each character of the word guess and gives
     * feedback on which that is in correct position, wrong position and which is
     * not in the answer word.
     * This is done by updating the AnswerType of each WordleCharacter of the
     * WordleWord.
     * 
     * @param wordGuess
     * @return wordleWord with updated answertype for each character.
     */
    public WordleWord makeGuess(String wordGuess) {
        if (!dictionary.isLegalGuess(wordGuess))
            throw new IllegalArgumentException("The word '" + wordGuess + "' is not a legal guess");

        WordleWord guessFeedback = matchWord(wordGuess, WORD);
        return guessFeedback;
    }

    /**
     * Generates a WordleWord showing the match between <code>guess</code> and
     * <code>answer</code>.
     *
     * @param guess  The guessed word.
     * @param answer The correct answer.
     * @return A WordleWord object representing the match.
     * @throws IllegalArgumentException if the guess and answer have different lengths.
     */
    public static WordleWord matchWord(String guess, String answer) {
        int wordLength = answer.length();
        if (guess.length() != wordLength) {
            throw new IllegalArgumentException("Guess and answer must have the same number of letters");
        }

        AnswerType[] feedback = new AnswerType[wordLength];
        HashMap<Character, Integer> letterCount = new HashMap<>();

        // First pass: Mark correct letters (green) and count occurrences of unmatched characters.
        for (int i = 0; i < wordLength; i++) {
            char answerChar = answer.charAt(i);
            if (guess.charAt(i) == answerChar) {
                feedback[i] = AnswerType.CORRECT;
            } else {
                feedback[i] = AnswerType.WRONG;
                letterCount.put(answerChar, letterCount.getOrDefault(answerChar, 0) + 1);
            }
        }

        // Second pass: Mark misplaced letters (yellow) using HashMap.
        for (int i = 0; i < wordLength; i++) {
            if (feedback[i] == AnswerType.CORRECT) continue; // Skip already correct letters.
            
            char guessChar = guess.charAt(i);
            if (letterCount.getOrDefault(guessChar, 0) > 0) {
                feedback[i] = AnswerType.MISPLACED;
                letterCount.put(guessChar, letterCount.get(guessChar) - 1);
            }
        }

        // Return the feedback in a WordleWord object.
        return new WordleWord(guess, feedback);
    }
}
