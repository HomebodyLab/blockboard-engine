package kr.blockboard.block;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class BlockService {

	private Map<String, Block> blocks = new LinkedHashMap<>();

	public Map<String, Block> createBlock(Block block) {
		String uuid = UUID.randomUUID().toString();
		this.blocks.put(uuid, block);
		return this.blocks;
	}

	public Block readBlock(String uuid) {
		return this.blocks.get(uuid);
	}

	public Map<String, Block> readBlocks() {
		return this.blocks;
	}

	public Block updateBlock(UUID uuid, Block block) {
		block.setUuid(uuid);
		this.blocks.put(uuid.toString(), block);
		return block;
	}

	public Map<String, Block> deleteBlock(String uuid) {
		this.blocks.remove(uuid);
		return this.blocks;
	}
}
