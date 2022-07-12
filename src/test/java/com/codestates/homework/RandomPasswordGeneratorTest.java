package com.codestates.homework;

import com.codestates.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RandomPasswordGeneratorTest {

    //given
        int expectedLength = 10;
        int expectedUpper = 2;
        int expectedLower = 5;
        int expectedNumeric = 2;
        int expectedSpecial = 1;
        int actual;
        String actual2;
        String pwd =RandomPasswordGenerator.generate(2,5,2,1);

    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        pwdLength();
        UpperCaseCount();
        LowerCaseCount();
        NumericCaseCount();
        SpecialCarsCount();

        System.out.println("pwd:" + pwd);

    }


    public void pwdLength() {


        //when
        actual = pwd.length();
        //then
        assertEquals(expectedLength, actual);
        System.out.println("expectedLength :" + actual);
    }
    public void UpperCaseCount() {


        //when
        actual = (int)pwd.chars()
                .filter(c->c >=65 &&c<=90)
                        .count();
        actual2 = pwd.chars()
                .filter(c->c >=65 &&c<=90)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        //then
        assertEquals(expectedUpper, actual);
        System.out.println("expectedUpper :" + actual);
        System.out.println(actual2);
    }
    public void LowerCaseCount() {


        //when
        actual = (int)pwd.chars()
                .filter(c->c >=97 &&c<=122)
                .count();
        actual2 = pwd.chars()
                .filter(c->c >=97 &&c<=122)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        //then
        assertEquals(expectedLower, actual);
        System.out.println("expectedLower :" + actual);
        System.out.println(actual2);
    }
    private void NumericCaseCount() {

        actual = (int)pwd.chars()
                .filter(c->c >='0' &&c<='9')
                .count();

        actual2 = pwd.chars()
                .filter(c->c >='0' &&c<='9')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        //then
        assertEquals(expectedNumeric, actual);
        System.out.println("expectedNumeric :"+ actual);
        System.out.println(actual2);

    }

    public void SpecialCarsCount() {


        actual = (int)pwd.chars()
                .filter(c->c >=33 &&c<=47)
                .count();
        actual2 = pwd.chars()
                .filter(c->c >=33 &&c<=47)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                                StringBuilder::append)
                .toString();


        //then
        assertEquals(expectedSpecial, actual);
        System.out.println("expectedSpecial :"+ actual2);

    }


}
