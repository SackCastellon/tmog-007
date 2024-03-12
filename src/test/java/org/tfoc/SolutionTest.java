package org.tfoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        var result = solution.isAnagram("anagram", "nagaram");
        assertThat(result).isTrue();
    }

    @Test
    void example2() {
        var result = solution.isAnagram("rat", "car");
        assertThat(result).isFalse();
    }

    @Test
    void test() {
        var random = new Random();
        var codePoints = IntStream.generate(() -> random.nextInt(Character.MAX_CODE_POINT))
            .limit(10_000)
            .toArray();

        var a = new String(codePoints, 0, codePoints.length);

        for (int i = codePoints.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            int tmp = codePoints[index];
            codePoints[index] = codePoints[i];
            codePoints[i] = tmp;
        }

        var b = new String(codePoints, 0, codePoints.length);

        var result = solution.isAnagram(a, b);
        assertThat(result).isTrue();
    }
}
