package kr.blockboard.api;

import kr.blockboard.block.Block;
import kr.blockboard.block.BlockService;
import kr.blockboard.logger.LogCode;
import kr.blockboard.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("block")
public class BlockController {

	private final Logger logger;
	private BlockService blockService = null;

	@Autowired
	public BlockController(MessageSource messageSource, BlockService blockService) {
		this.logger = new Logger(getClass(), messageSource);
		this.logger.info(LogCode.EGN_API_0001, "BlockController.class");

		this.blockService = blockService;
		this.logger.info(LogCode.EGN_API_0002, "BlockService.class");
	}
	
	@PostMapping(value = "")
	public ResponseEntity<Map<String, Block>> createBlock(@RequestBody Block block) {
		Map<String, Block> blocks = this.blockService.createBlock(block);
		return ResponseEntity.ok(blocks);
	}
	
	@GetMapping(value = "single")
	public ResponseEntity<Block> readBlock(@RequestParam("uuid") String uuid) {
		Block block = this.blockService.readBlock(uuid);
		return ResponseEntity.ok(block);
	}
	
	@GetMapping(value = "multiple")
	public ResponseEntity<Map<String, Block>> readBlocks() {
		Map<String, Block> blocks = this.blockService.readBlocks();
		return ResponseEntity.ok(blocks);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<Block> updateBlock(@RequestParam("uuid") String uuid, @RequestBody Block block) {
		Block changeBlock = this.blockService.updateBlock(UUID.fromString(uuid), block);
		return ResponseEntity.ok(changeBlock);
	}
	
	@DeleteMapping(value = "")
	public ResponseEntity<Map<String, Block>> deleteBlock(@RequestParam("uuid") String uuid) {
		Map<String, Block> blocks = this.blockService.deleteBlock(uuid);
		return ResponseEntity.ok(blocks);
	}
}
