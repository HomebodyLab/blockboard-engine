package kr.blockboard.logger;

import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

public class Logger {

    private final org.slf4j.Logger LOG;
    private final MessageSource messageSource;

    public Logger(Class clazz, MessageSource messageSource) {
        this.LOG = LoggerFactory.getLogger(clazz);
        this.messageSource = messageSource;
    }

    public void info(LogCode logCode, Object... args) {
        this.LOG.info(this.messageSource.getMessage(logCode.name(), args, LocaleType.getLocale()));
    }

    public void debug(LogCode logCode, Object... args) {
        this.LOG.debug(this.messageSource.getMessage(logCode.name(), args, LocaleType.getLocale()));
    }

    public void warn(LogCode logCode, Object... args) {
        this.LOG.warn(this.messageSource.getMessage(logCode.name(), args, LocaleType.getLocale()));
    }

    public void error(LogCode logCode, Object... args) {
        this.LOG.error(this.messageSource.getMessage(logCode.name(), args, LocaleType.getLocale()));
    }
}
