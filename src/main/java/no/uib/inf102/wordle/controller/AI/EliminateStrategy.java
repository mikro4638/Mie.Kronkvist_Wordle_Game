package no.uib.inf102.wordle.controller.AI;

import java.util.Random;
import no.uib.inf102.wordle.model.Dictionary;
import no.uib.inf102.wordle.model.word.WordleWord;
import no.uib.inf102.wordle.model.word.WordleWordList;

/**
 * This strategy eliminates guesses that are impossible based on the feedback 
 * given throughout the game.
 */
public class EliminateStrategy implements IStrategy {

    private Dictionary dictionary;
    private WordleWordList guesses;
    private Random random = new Random();

    /**
     * Constructor for EliminateStrategy.
     * Initializes the dictionary and resets the guess list.
     * 
     * @param dictionary the dictionary containing valid words
     */
    public EliminateStrategy(Dictionary dictionary) {
        this.dictionary = dictionary;
        reset();
    }

    /**
     * Makes a guess based on the provided feedback.
     * Filters out impossible words based on the feedback and chooses a 
     * random word from the remaining possible answers.
     * 
     * @param feedback the feedback received from the last guess
     * @return a valid guess or an empty string if no guesses are left
     */
    @Override
    public String makeGuess(WordleWord feedback) {
        if (feedback != null) {
            guesses.eliminateWords(feedback); // Eliminate impossible words based on feedback
        }

        int size = guesses.size();
        if (size == 0) {
            return ""; // Handle case when no guesses are left
        }

        // Choose a random word from the possible guesses after eliminating
        return getRandomGuess(size);
    }

    /**
     * Returns a random guess from the possible answers.
     *
     * @param size the number of possible guesses left
     * @return a randomly selected word
     */
    private String getRandomGuess(int size) {
        int randIndex = random.nextInt(size);
        return guesses.possibleAnswers().get(randIndex);
    }

    /**
     * Resets the strategy by creating a new WordleWordList based on the 
     * current dictionary.
     */
    @Override
    public void reset() {
        guesses = new WordleWordList(dictionary);
    }
}
