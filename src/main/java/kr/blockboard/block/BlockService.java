package kr.blockboard.block;

import java.util.Map;
import java.util.LinkedHashMap;
import org.springframework.stereotype.Service;

@Service
public class BlockService {

	private Map<String, Block> blocks = new LinkedHashMap<>();

	public Map<String, Block> createBlock() {
		return new LinkedHashMap<>();
	}

	public Block readBlock(String uuid) {
		return this.blocks.get(uuid);
	}

	public Map<String, Block> readBlocks() {
		return this.blocks;
	}

	public Block updateBlock(String uuid, Block block) {
		block.setUuid(uuid);
		this.blocks.put(uuid, block);
		return block;
	}

	public Map<String, Block> deleteBlock() {
		return new LinkedHashMap<>();
	}
}
