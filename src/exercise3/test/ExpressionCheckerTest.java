package exercise3.test;

import exercise3.ExpressionChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionCheckerTest {
ExpressionChecker expressionChecker = new ExpressionChecker();
    @Test
    void check() {
        String expression = "2(3+a)*b((q-1):3+4)";
        assertTrue(expressionChecker.check(expression));
        expression = "23+a)*b((q-1:3+4)";
        assertFalse(expressionChecker.check(expression));
    }
}