package kr.blockboard.logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
class LogCodeTest {

	private final Logger logger;

	@Autowired
    LogCodeTest(MessageSource messageSource) {
        this.logger = new Logger(getClass(), messageSource);
    }

    @Test
	void contextLoads() {
		this.logger.info(LogCode.ENGINE_DEFAULT_0000, "TEST1");
		this.logger.warn(LogCode.ENGINE_DEFAULT_0000, "TEST2");
		this.logger.debug(LogCode.ENGINE_DEFAULT_0000, "TEST3");
		this.logger.error(LogCode.ENGINE_DEFAULT_0000, "TEST4");
	}
}
