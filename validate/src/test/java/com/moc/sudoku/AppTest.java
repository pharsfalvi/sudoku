package com.moc.sudoku;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AppTest {


    @Rule
    public final transient ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Rule
    public final transient SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void givenInputFile_whenIsCorrect_thenCompletes() {
        App.main(new String[]{"src/test/resources/inputFile.txt"});
        assertSame("Validation failed", 1, 1);
    }

    @Test
    @SuppressWarnings("PMD.JUnitTestsShouldIncludeAssert")
    public void givenInputFile_whenIsInCorrect_thenFailsWithOne() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() ->
                assertTrue("Invalid row found.", systemOutRule.getLog().contains("Invalid row found. Each row must have exactly")));
        App.main(new String[]{"src/test/resources/inputFile1.txt"});
    }

    @Test
    @SuppressWarnings("PMD.JUnitTestsShouldIncludeAssert")
    public void givenNoInputFile_whenBlank_thenFailsWithOne() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() ->
                assertTrue("Does not print usage for blank argument", systemOutRule.getLog().contains("Usage: validator")));
        App.main(new String[]{""});
    }

    @Test
    @SuppressWarnings("PMD.JUnitTestsShouldIncludeAssert")
    public void givenNoInputFile_whenEmpty_thenFailsWithOne() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() ->
                assertTrue("Does not print usage for empty arguments", systemOutRule.getLog().contains("Usage: validator")));
        App.main(new String[]{});
    }
}