package kr.blockboard.block;

import java.time.LocalDateTime;
import java.util.UUID;

public class BlockFactory {

    public static Block newInstance() {
        LocalDateTime currentTime = LocalDateTime.now();

        return new Block(UUID.randomUUID(), currentTime);
    }
}
