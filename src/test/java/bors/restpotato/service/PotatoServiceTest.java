package bors.restpotato.service;

import bors.restpotato.service.impl.PotatoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

class PotatoServiceTest {

    @Test
    void prepareStringsTest() {
        PotatoService potatoService = new PotatoServiceImpl();
        List<String> strings = Arrays.asList(
                "Тихо струится река серебристая",
                "В царстве вечернем зеленой весны.",
                "Солнце садится за горы лесистые.",
                "Рог золотой выплывает луны.");
        List<String> expectedStrings = Arrays.asList(
                "(27): Рог золотой выплывает луны.",
                "(30): Тихо струится река серебристая",
                "(32): Солнце садится за горы лесистые.",
                "(33): В царстве вечернем зеленой весны.");
        Assert.isTrue(potatoService.prepareStrings(strings).equals(expectedStrings), "Some of the strings are not equal");
    }

    @Test
    void getMonthNameValidTest() {
        PotatoService potatoService = new PotatoServiceImpl();
        String expected = "Я-Н-В-А-Р-Ь";
        Assert.isTrue(potatoService.getMonthName(1).equals(expected), "Strings are not equal");
    }

    @Test
    void getMonthNameInvalidTest() {
        PotatoService potatoService = new PotatoServiceImpl();
        String expected = "INCORRECT INPUT DATA";
        Assert.isTrue(potatoService.getMonthName(0).equals(expected), "Strings are not equal");
    }
}