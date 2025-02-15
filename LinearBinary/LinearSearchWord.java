public class LinearSearchWord {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a powerful programming language.",
            "Linear search is simple but inefficient.",
            "Data structures and algorithms are important."
        };

        String word = "search";
        String result = findSentenceWithWord(sentences, word);

        System.out.println("Result: " + result);
    }
}

