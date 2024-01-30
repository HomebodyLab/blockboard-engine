package kr.blockboard.api;

import org.springframework.beans.factory.annotation.Autowired;
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

	private BlockService blockService = null;

	@Autowired
	public BlockController(BlockService blockService) {
		this.blockService = blockService;
	}
	
	@PostMapping(value = "")
	public ResponseEntity<Map<String, Block>> createBlock(@RequestBody Block block) {
		Map<String, Block> blocks = this.blockService.createBlock();
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
		Block changeBlock = this.blockService.updateBlock(uuid, block);
		return ResponseEntity.ok(changeBlock);
	}
	
	@DeleteMapping(value = "")
	public ResponseEntity<Map<String, Block>> deleteBlock() {
		Map<String, Block> blocks = this.blockService.deleteBlock();
		return ResponseEntity.ok(blocks);
	}
}
