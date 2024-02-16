package kr.blockboard.api;

import kr.blockboard.logger.LocaleType;
import kr.blockboard.logger.LogCode;
import kr.blockboard.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import kr.blockboard.block.Block;
import kr.blockboard.block.BlockService;

@RestController
@RequestMapping("block")
public class BlockController {

	private final Logger logger;
	private BlockService blockService = null;

	@Autowired
	public BlockController(MessageSource messageSource, BlockService blockService) {
		this.logger = new Logger(getClass(), messageSource);
		this.blockService = blockService;
	}
	
	@PostMapping(value = "")
	public ResponseEntity<Map<String, Block>> createBlock(@RequestBody Block block) {
		Map<String, Block> blocks = this.blockService.createBlock(block);
		return ResponseEntity.ok(blocks);
	}
	
	@GetMapping(value = "single")
	public ResponseEntity<Block> readBlock(@RequestParam("uuid") String uuid) {
		this.logger.info(LogCode.ENGINE_DEFAULT_0000, "ABCD TEST");

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
		Block changeBlock = this.blockService.updateBlock(uuid, block);
		return ResponseEntity.ok(changeBlock);
	}
	
	@DeleteMapping(value = "")
	public ResponseEntity<Map<String, Block>> deleteBlock(@RequestParam("uuid") String uuid) {
		Map<String, Block> blocks = this.blockService.deleteBlock(uuid);
		return ResponseEntity.ok(blocks);
	}
}
