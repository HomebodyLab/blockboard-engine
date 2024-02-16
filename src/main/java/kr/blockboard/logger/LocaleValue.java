package kr.blockboard.logger;

/**
 * This class can call information from files set in application.yaml.
 *
 * @author jskang
 */
public class LocaleValue {

    protected static String locale = "ko_kr";
    protected static String[] basename = new String[]{"messages/log"};
    protected static String encoding = "UTF-8";

    /**
     * Load set locale information.
     *
     * @return the locale.
     * @author jskang
     */
    public static String getLocale() {
        return locale;
    }

    /**
     * Load set basename path.
     *
     * @return the basenames.
     * @author jskang
     */
    public static String[] getBasename() {
        return basename;
    }

    /**
     * Load set encoding information.
     *
     * @return the encoding.
     * @author jskang
     */
    public static String getEncoding() {
        return encoding;
    }
}