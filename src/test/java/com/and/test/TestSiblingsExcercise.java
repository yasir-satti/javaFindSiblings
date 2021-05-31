package com.and.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.and.siblingsExcercise.SiblingsExcercise;

public class TestSiblingsExcercise {
   SiblingsExcercise siblingsExcercise;

   @Before
   public void init(){
      siblingsExcercise = new SiblingsExcercise();
   }
   
   @Test
   public void givenThreeDigitStringItShouldReturnSiblings(){
      String testInpt = "326";
      String expectedResult = "632,623,362,326,263,236";

      assertEquals(siblingsExcercise.solution(testInpt), expectedResult);
   }

   @Test
   public void givenAlphaNumericStringWithoutSpaceItShouldReturnSiblings(){
      String testInpt = "A3B2C6D";
      String expectedResult = "632,623,362,326,263,236";

      assertEquals(siblingsExcercise.solution(testInpt), expectedResult);
   }

   @Test
   public void givenAlphaNumericStringWithSpaceItShouldReturnSiblings(){
      String testInpt = "A 3B2 C6D";
      String expectedResult = "632,623,362,326,263,236";

      assertEquals(siblingsExcercise.solution(testInpt), expectedResult);
   }

   @Test
   public void givenAlphaStringWithoutNumericShouldReturnNoSiblings(){
      String testInpt = "ABCD";
      String expectedResult = "Input does not contain digits!!";

      assertEquals(siblingsExcercise.solution(testInpt), expectedResult);
   }

   @Test
   public void givenThreeDigitStringItShouldReturnSiblings2(){
      String testInpt = "122";
      String expectedResult = "221,212,221,212,122,122";

      assertEquals(siblingsExcercise.solution(testInpt), expectedResult);
   }

   
   @Test
   public void givenThreeDigitStringItShouldReturnSiblings3(){
      String testInpt = "203";
      String expectedResult = "320,302,230,203,032,023";

      assertEquals(siblingsExcercise.solution(testInpt), expectedResult);
   }


   @Test
   public void givenEmptyStringShouldReturnNoSiblings(){
      String testInpt = "";
      String expectedResult = "Input is empty!!";

      assertEquals(siblingsExcercise.solution(testInpt), expectedResult);
   }
}