package kr.hs.dgsw.Template.Forecast.Enum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public enum Weather {
    CLEAR("맑음"),
    MIST("흐림"),
    SNOW("눈"),
    STORM("폭풍"),
    RAIN("비"),
    THUNDER("천둥");

    private final String title;

    Weather(String title) {
        this.title = title;
    }

    public static Weather getWeather(String code) {
        Integer codeValue = Integer.parseInt(code);

        if (codeValue >= 0 && codeValue < 4) {
            return CLEAR;
        } else if (codeValue >= 4 && codeValue < 20) {
            return MIST;
        } else if (codeValue >= 20 && codeValue < 30 && codeValue != 22 && codeValue != 29) {
            return RAIN;
        } else if (codeValue == 22) {
            return SNOW;
        } else if (codeValue == 29) {
            return THUNDER;
        } else if (codeValue >= 30 && codeValue < 40) {
            return STORM;
        } else if (codeValue >= 40 && codeValue < 50) {
            return MIST;
        } else if (codeValue >= 50 && codeValue < 95) {
            return RAIN;
        } else if (codeValue >= 95 && codeValue < 100) {
            return THUNDER;
        }

        return null;
    }

}
