package kr.blockboard.api;

import kr.blockboard.block.Block;
import kr.blockboard.block.BlockService;
import kr.blockboard.block.BlockVo;
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
	public ResponseEntity<Map<String, Block>> createBlock(@RequestBody BlockVo blockVo) {
		Map<String, Block> blocks = this.blockService.createBlock(blockVo);
		return ResponseEntity.ok(blocks);
	}
	
	@GetMapping(value = "single")
	public ResponseEntity<BlockVo> readBlock(@RequestParam("uuid") String uuid) {
		BlockVo block = this.blockService.readBlock(uuid);
		return ResponseEntity.ok(block);
	}
	
	@GetMapping(value = "multiple")
	public ResponseEntity<Map<String, BlockVo>> readBlocks() {
		Map<String, BlockVo> blocks = this.blockService.readBlocks();
		return ResponseEntity.ok(blocks);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<BlockVo> updateBlock(@RequestParam("uuid") String uuid, @RequestBody BlockVo blockVo) {
		BlockVo changeBlock = this.blockService.updateBlock(UUID.fromString(uuid), blockVo);
		return ResponseEntity.ok(changeBlock);
	}
	
	@DeleteMapping(value = "")
	public ResponseEntity<Map<String, BlockVo>> deleteBlock(@RequestParam("uuid") String uuid) {
		Map<String, BlockVo> blocks = this.blockService.deleteBlock(uuid);
		return ResponseEntity.ok(blocks);
	}
}
