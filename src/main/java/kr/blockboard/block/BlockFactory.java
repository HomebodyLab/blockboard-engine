package kr.blockboard.block;

import java.time.LocalDateTime;
import java.util.UUID;

public class BlockFactory {

    public static Block newInstance(String title) {
        LocalDateTime currentTime = LocalDateTime.now();

        return new Block(UUID.randomUUID(), title, currentTime);
    }
}
