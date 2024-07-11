package kr.blockboard.block;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class BlockService {

	private Map<String, Block> blocks = new LinkedHashMap<>();

	public Map<String, Block> createBlock(BlockVo blockVo) {
		Block block = BlockFactory.newInstance(blockVo);
		this.blocks.put(block.getUuid().toString(), block);

		return this.blocks;
	}

	public BlockVo readBlock(String uuid) {
		return this.blocks.get(uuid).blockVoTranstion();
	}

	public Map<String, BlockVo> readBlocks() {
		Map<String, BlockVo> blockVos = new LinkedHashMap<>();

		for (Map.Entry<String, Block> block : this.blocks.entrySet()) {
			blockVos.put(block.getKey(), block.getValue().blockVoTranstion());
		}

		return blockVos;
	}

	public BlockVo updateBlock(UUID uuid, BlockVo blockVo) {
		Block block = BlockFactory.newInstance(blockVo);
		this.blocks.put(uuid.toString(), BlockFactory.newInstance(blockVo));
		return this.blocks.get(uuid.toString()).blockVoTranstion();
	}

	public Map<String, BlockVo> deleteBlock(String uuid) {
		this.blocks.remove(uuid);
		return this.readBlocks();
	}
}
