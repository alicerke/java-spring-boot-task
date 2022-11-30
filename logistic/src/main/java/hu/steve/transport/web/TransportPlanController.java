package hu.steve.transport.web;

import java.util.List;

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
import hu.steve.transport.dto.TransportPlanDto;
import hu.steve.transport.mapper.SectionMapper;
import hu.steve.transport.mapper.TransportPlanMapper;
import hu.steve.transport.model.TransportPlan;
import hu.steve.transport.service.TransportPlanService;

@RestController
@RequestMapping("/api/transport")
public class TransportPlanController {

	private TransportPlanMapper transportPlanMapper;
	private TransportPlanService transportPlanService;
	private SectionMapper sectionMapper;
	
	public TransportPlanController(TransportPlanMapper transportPlanMapper, TransportPlanService transportPlanService,
			SectionMapper sectionMapper) {
		super();
		this.transportPlanMapper = transportPlanMapper;
		this.transportPlanService = transportPlanService;
		this.sectionMapper =sectionMapper;
	}
	
	@GetMapping
	public List<TransportPlanDto> getAllTransportPlan(){
		return transportPlanMapper.transportPlanListToDto(transportPlanService.getAll());
	}
	
	@GetMapping("/{id}")
	public TransportPlanDto getTransportPlanById(@PathVariable long id) {
		TransportPlan trasportPlan = transportPlanService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return transportPlanMapper.transportPlanToDto(trasportPlan);
	}
	
	@PostMapping
	public TransportPlanDto createTransportPlan(@RequestBody TransportPlanDto transportPlanDto) {
		TransportPlan trasportPlan = transportPlanService.save(transportPlanMapper.dtoToTransportPlan(transportPlanDto));
		return transportPlanMapper.transportPlanToDto(trasportPlan);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TransportPlanDto> updateTransportPlan(@PathVariable long id, @RequestBody TransportPlanDto transportPlanDto) {
		transportPlanDto.setId(id);
		TransportPlan updateTransportPlan = transportPlanService.update(transportPlanMapper.dtoToTransportPlan(transportPlanDto));
		return updateTransportPlan == null ? ResponseEntity.notFound().build() 
				: ResponseEntity.ok(transportPlanMapper.transportPlanToDto(updateTransportPlan));		
	}
	
	@DeleteMapping("/{id}")
	public void deleteTransportPlan(@PathVariable long id) {
		transportPlanService.delete(id);
	}
	
	/* Section CRUD */
	@PostMapping("/{id}/sections")
	public TransportPlanDto addSectionToTransportPlan(@PathVariable long id, @RequestBody SectionDto sectionDto) {
		return transportPlanMapper.transportPlanToDto(
				transportPlanService.addSectiontoTransportPlan(id, sectionMapper.dtoToSection(sectionDto))
				);
	}
	
	@DeleteMapping("/{id}/sections/{sectionId}")
	public TransportPlanDto removeSectionFromTransportPlan(@PathVariable long id, @PathVariable long sectionId) {
		return transportPlanMapper.transportPlanToDto(transportPlanService.removeSecetionfromTransportPlan(id, sectionId));
	}
	
}
