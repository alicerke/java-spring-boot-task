package hu.steve.transport.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.steve.transport.dto.SectionDto;
import hu.steve.transport.mapper.SectionMapper;
import hu.steve.transport.model.Section;
import hu.steve.transport.service.SectionService;

@RestController
@RequestMapping("/api/sections")
public class SectionController {
	
	private SectionService sectionService;
	private SectionMapper sectionMapper;
	
	public SectionController(SectionService sectionService, SectionMapper sectionMapper) {
		super();
		this.sectionService = sectionService;
		this.sectionMapper = sectionMapper;
	}
	
	@GetMapping
	public List<SectionDto> getAllSection(){
		return sectionMapper.sectionListToDto(sectionService.getAll());
	}
	
	@GetMapping("/{id}")
	public SectionDto getSectionById(@PathVariable long id) {
		Section section = sectionService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return sectionMapper.sectionToDto(section);
	}
	
	@PostMapping
	public SectionDto createSection(@RequestBody @Valid SectionDto sectionDto) {
		Section section = sectionService.save(sectionMapper.dtoToSection(sectionDto));
		return sectionMapper.sectionToDto(section);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SectionDto> updateSection(@PathVariable long id, @RequestBody @Valid SectionDto sectionDto) {
		sectionDto.setId(id);
		Section updateSection = sectionService.update(sectionMapper.dtoToSection(sectionDto));
		return updateSection == null ? ResponseEntity.notFound().build() 
				: ResponseEntity.ok(sectionMapper.sectionToDto(updateSection));		
	}
	
	@DeleteMapping("/{id}")
	public void deleteSection(@PathVariable long id) {
		sectionService.delete(id);
	}
}
