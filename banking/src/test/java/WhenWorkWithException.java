import org.junit.Test;

public class WhenWorkWithException {

    WordCounter wordCounter=new WordCounter();
    @Test (expected = FileHasNoWordException.class)
    public void shouldThrowMeaningFullException() throws Exception{
        wordCounter.numberOfTheWordInAFile("src/main/resources/no_word.txt");
    }
}
