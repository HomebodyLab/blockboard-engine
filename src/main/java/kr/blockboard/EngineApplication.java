package kr.blockboard;

import kr.blockboard.logger.LogCode;
import kr.blockboard.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;

@SpringBootApplication
public class EngineApplication {

	private static Logger logger = null;

	@Autowired
    public EngineApplication(MessageSource messageSource) {
		this.logger = new Logger(getClass(), messageSource);
    }

    public static void main(String[] args) {
		SpringApplication.run(EngineApplication.class, args);
		logger.info(LogCode.EGN_DEF_0001);
	}

}
