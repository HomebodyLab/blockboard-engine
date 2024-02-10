package kr.blockboard.log;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.i18n.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class LocaleConfig implements WebMvcConfigurer, LocaleContextResolver {

    @Value("${locale.language}")
    private String locale;
    @Value("${locale.messages.encoding}")
    private String encoding;

    @Bean
    public LocaleResolver localeResolver() {
        LocaleValue.locale = locale;
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(LocaleType.getLocale(LocaleValue.locale));
        cookieLocaleResolver.setCookieName("APPLICATION_LOCALE");
        return cookieLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public LocaleContext resolveLocaleContext(ServerWebExchange exchange) {
        String language = exchange.getRequest().getQueryParams().getFirst("lang");
        Locale targetLocale = Locale.getDefault();
        if (language != null && !language.isEmpty()) {
            targetLocale = Locale.forLanguageTag(language);
        }
        return new SimpleLocaleContext(targetLocale);
    }

    @Override
    public void setLocaleContext(ServerWebExchange exchange, LocaleContext localeContext) {
        throw new UnsupportedOperationException("Not Supported");
    }

    @Bean
    public MessageSource messageSource() {
        LocaleValue.basename = new String[]{"messages/log"};
        LocaleValue.encoding = encoding;

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.addBasenames(LocaleValue.basename);
        messageSource.setDefaultEncoding(LocaleValue.encoding);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setCacheSeconds(60 * 100);
        return messageSource;
    }
}