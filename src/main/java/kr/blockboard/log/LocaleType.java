package kr.blockboard.log;

import java.util.Arrays;
import java.util.Locale;

/**
 * A predefined class with local information that can be set.
 * Regions not provided by this class are not supported.
 *
 * @author jskang
 */
public enum LocaleType {
    KOKR("ko", "kr"),
    ENUS("en", "us");

    private String language;
    private String country;

    LocaleType(String l, String c) {
        this.language = l;
        this.country = c;
    }

    /**
     * You can return a Locale class for any country you want.
     *
     * @param language the language you want.
     * @param country city you want.
     *
     * @return Locale class.
     * @author jskang
     */
    public static Locale getLocale(String language, String country) {
        return Arrays.stream(values())
                .filter(locales -> locales.language.equals(language) && locales.country.equals(country))
                .findFirst()
                .map(localeType -> Locale.of(localeType.language, localeType.country))
                .orElse(Locale.of("ko", "kr"));
    }

    /**
     * You can return a Locale class for any country you want.
     * default locale is korean.
     *
     * @return Locale class.
     * @author jskang
     */
    public static Locale getLocale() {
        String locale = LocaleValue.locale;
        if (locale == null || locale.isEmpty()) {
            return Locale.of("ko", "kr");
        }

        String[] split = locale.split("_");
        if (split.length != 2) {
            return Locale.of("ko", "kr");
        }

        return getLocale(split[0], split[1]);
    }

    /**
     * You can return a Locale class for any country you want.
     *
     * @param localeType Value provided by LocaleType Enum class.
     *
     * @return Locale class.
     * @author jskang
     */
    public static Locale getLocale(LocaleType localeType) {
        return getLocale(localeType.language, localeType.country);
    }

    /**
     * You can return a Locale class for any country you want.
     *
     * @param locale the language you want and city you want. (ex. ko_kr | en_us)
     *
     * @return Locale class.
     * @author jskang
     */
    public static Locale getLocale(String locale) {
        if (locale == null || locale.isEmpty()) {
            return Locale.of("ko", "kr");
        }

        String[] split = locale.split("_");
        if (split.length < 2) {
            return Locale.of("ko", "kr");
        }

        return getLocale(split[0], split[1]);
    }

    /**
     * You can return a LocaleType class for any country you want.
     *
     * @param language the language you want.
     * @param country city you want.
     *
     * @return LocaleType class.
     * @author jskang
     */
    public static LocaleType getLocalType(String language, String country) {
        return Arrays.stream(values())
                .filter(locales -> locales.language.equals(language) && locales.country.equals(country))
                .findFirst()
                .orElse(LocaleType.KOKR);
    }

    /**
     * You can return a LocaleType class for any country you want.
     *
     * @return LocaleType class.
     * @author jskang
     */
    public static LocaleType getLocalType() {
        String locale = LocaleValue.locale;
        if (locale == null || locale.isEmpty()) {
            return LocaleType.KOKR;
        }

        String[] split = locale.split("_");
        if (split.length != 2) {
            return LocaleType.KOKR;
        }

        return getLocalType(split[0], split[1]);
    }

    /**
     * You can return a LocaleType class for any country you want.
     *
     * @param locale the language you want and city you want. (ex. ko_kr | en_us)
     *
     * @return LocaleType class.
     * @author jskang
     */
    public static LocaleType getLocalType(String locale) {
        if (locale == null || locale.isEmpty()) {
            return LocaleType.KOKR;
        }

        String[] split = locale.split("_");
        if (split.length < 2) {
            return LocaleType.KOKR;
        }

        return getLocalType(split[0], split[1]);
    }
}