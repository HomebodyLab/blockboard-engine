package kr.blockboard.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
class LogCodeTest {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private MessageSource messageSource;

	@Test
	void contextLoads() {
		LOG.info(messageSource.getMessage(LogCode.ENGINE_DEFAULT_0000.name(), new String[]{"Engine default logging..."}, LocaleType.getLocale()));
	}

}
