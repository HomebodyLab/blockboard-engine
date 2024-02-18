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
		this.logger.info(LogCode.EGN_DEF_0000, "TEST1");
		this.logger.warn(LogCode.EGN_DEF_0001, "TEST2");
		this.logger.debug(LogCode.EGN_DEF_0002, "TEST3");
		this.logger.error(LogCode.EGN_DEF_0003, "TEST4");
	}
}
