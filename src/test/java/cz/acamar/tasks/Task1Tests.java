package cz.acamar.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Tests {

    private Task1 task1 = new Task1();

    @ParameterizedTest
    @MethodSource("stringsAndLastWordLength")
    void test_lastWordLength(String str, int lastWordLength) {
        assertEquals(lastWordLength, task1.lengthOfLastWord(str));
    }

    @Test
    void itShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            task1.lengthOfLastWord(null);
        });
    }

    private static Stream<Arguments> stringsAndLastWordLength() {
        return Stream.of(
            Arguments.of("Hello world", 5),
            Arguments.of("   fly me   to   the moon  ", 4),
            Arguments.of("William Shakespeare was an English   playwright", 10),
            Arguments.of("William. Shakespeare: was an English   .playwright.... ...  ,,", 10)
        );
    }
}
