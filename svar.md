# Runtime Analysis
For each method of the tasks give a runtime analysis in Big-O notation and a description of why it has this runtime.

**If you have implemented new methods not listed you must add these as well, e.g. any helper methods. You need to show how you analyzed any methods used by the methods listed below.**

The runtime should be expressed using these three parameters:
   * `n` - number of words in the list allWords
   * `m` - number of words in the list possibleWords
   * `k` - number of letters in the wordleWords


## Task 1 - matchWord
* `WordleAnswer::matchWord`: O(k)

Description of Runtime
Parameters:

k: Number of letters in both the guess and the answer.
First Pass: Iterates through each character of guess and answer (length k) to check for matches and count occurrences of unmatched characters. This takes O(k) time.

Second Pass: Iterates again to update feedback for misplaced letters using the counts from the first pass, also taking O(k) time.

Overall, the total runtime is O(k) due to the two linear passes over the word length.


## Task 2 - EliminateStrategy
* `WordleWordList::eliminateWords`: O(m * k)
The method iterates through the possibleAnswers list containing `m` words. For each candidate word, the WordleWord.isPossibleWord method is called, which performs a comparison of the candidate (length `k`) against the feedback. This comparison takes O(k) time per word. Since we need to check all `m` candidate words, the total time complexity of this method becomes O(m * k). Although updating the list of possible answers takes O(m), it is dominated by the previous iterations and does not affect the overall complexity.

## Task 3 - FrequencyStrategy
* `FrequencyStrategy::makeGuess`:  O(m * k)
The makeGuess method first calls guesses.eliminateWords(feedback), which has a runtime of O(m * k). Next, it calculates the frequency table in O(m * k) by iterating through all m possible words and processing each of their k letters. Finally, while iterating through all possible answers, it calls calculateScore for each word, which takes O(k). As a result, the overall time complexity remains O(m * k), dominated by the initial word elimination and frequency table calculation


# Task 4 - Make your own (better) AI
In MyStrategy, I have enhanced performance compared to FrequencyStrategy by using a more efficient approach to word guessing. My strategy utilizes letter frequencies to calculate "expected scores" for each guess, increasing the chances of identifying the correct word faster.

Main Changes:

Dynamic Word Elimination:
Enhanced feedback handling with guesses.eliminateWords(feedback) removes words that don't match the feedback, effectively narrowing down possibilities.

Calculation of Expected Scores:
Instead of just considering letter frequencies, calculateExpectedScores calculates a total score for each word based on these frequencies, providing a better assessment for guesses.

Unique Letters for Optimization:
The calculateFrequencyScore method focuses on unique letters in guesses, reducing overlap and maximizing information gain for quicker identification of correct letters.

Frequency Calculation:
The calculateLetterFrequencies method tracks letter occurrences in possible answers, offering a more accurate statistic for evaluating guesses.

Result:
These improvements lead to a more intelligent strategy with a higher win percentage and fewer guesses on average. By leveraging insights from letter frequencies, MyStrategy makes more informed choices, significantly enhancing guessing efficiency.