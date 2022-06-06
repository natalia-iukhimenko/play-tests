package ru.iukhimenko.play.utils;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class Utils {
    public double extractPrice(String priceString) {
        Pattern pattern = Pattern.compile("(\\d+\\.\\d+)\\d*");
        Matcher matcher = pattern.matcher(priceString);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group());
        } else {
            throw new AssertionError("Failed to extract product price");
        }
    }
}
