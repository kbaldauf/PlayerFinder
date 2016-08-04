package com.kbaldauf.playerfinder.util;

import android.graphics.Color;

import com.kbaldauf.playerfinder.model.Team;

import java.util.List;

public class ModelUtil {

    public static String convertColorCodeToHex(String color) {
        if (! color.startsWith("#")) {
            color = "#" + color;
        }
        return color;
    }

    public static int getParsedColor(String color) {
        return Color.parseColor(convertColorCodeToHex(color));
    }

    public static List<String> convertColorCodeListToHex(List<String> colors) {
        for (int i = 0; i < colors.size(); i++) {
            colors.set(i, convertColorCodeToHex(colors.get(i)));
        }
        return colors;
    }

    public static int[] getParsedColorList(List<String> colors) {
        int[] parsedColors = new int[colors.size()];
        for (int i = 0; i < colors.size(); i++) {
            parsedColors[i] = getParsedColor(colors.get(i));
        }
        return parsedColors;
    }

    public static String getBuiltTeamName(Team team) {
        return String.format("%s  %s", team.getName(), team.getNickname());
    }
}
