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

import hu.steve.transport.dto.AddressDto;
import hu.steve.transport.dto.MilestoneDto;
import hu.steve.transport.mapper.AddressMapper;
import hu.steve.transport.mapper.MilestoneMapper;
import hu.steve.transport.model.Milestone;
import hu.steve.transport.service.MilestoneService;

@RestController
@RequestMapping("api/milestone")
public class MilestoneController {

	private MilestoneMapper milestoneMapper;
	private MilestoneService milestoneService;
	private AddressMapper addressMapper;
	
	public MilestoneController(MilestoneMapper milestoneMapper, MilestoneService milestoneService,AddressMapper addressMapper) {
		super();
		this.milestoneMapper = milestoneMapper;
		this.milestoneService = milestoneService;
		this.addressMapper = addressMapper;
	}
	
	@GetMapping
	public List<MilestoneDto> getAllMilestone(){
		return milestoneMapper.milestoneListToDto(milestoneService.getAll());
	}
	
	@GetMapping("/{id}")
	public MilestoneDto getMilestoneById(@PathVariable long id) {
		Milestone milestone = milestoneService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return milestoneMapper.milestoneToDto(milestone);
	}
	
	@PostMapping
	public MilestoneDto createMilestone(@RequestBody MilestoneDto milestoneDto) {
		Milestone milestone = milestoneService.save(milestoneMapper.dtoToMilestone(milestoneDto));
		return milestoneMapper.milestoneToDto(milestone);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MilestoneDto> updateMilestone(@PathVariable long id, @RequestBody MilestoneDto milestoneDto) {
		milestoneDto.setId(id);
		Milestone updateMilestone = milestoneService.update(milestoneMapper.dtoToMilestone(milestoneDto));
		return updateMilestone == null ? ResponseEntity.notFound().build() 
				: ResponseEntity.ok(milestoneMapper.milestoneToDto(updateMilestone));		
	}
	
	@DeleteMapping("/{id}")
	public void deleteMilestone(@PathVariable long id) {
		milestoneService.delete(id);
	}
	
	@PostMapping("/{id}/address")
	public MilestoneDto addAddressByMilestone(@PathVariable long id, @RequestBody AddressDto addressDto) {
		return milestoneMapper.milestoneToDto(milestoneService.addAddressToMilestone(id, addressMapper.dtoToAddress(addressDto)));
	}
	
	@PutMapping("/{id}/address")
	public MilestoneDto replaceAddress(@PathVariable long id, @RequestBody AddressDto addressDto) {
		return milestoneMapper.milestoneToDto(milestoneService.replaceAddress(id, addressMapper.dtoToAddress(addressDto)));
	}
	
	@DeleteMapping("/{id}/address")
	public MilestoneDto removeAddressFromMilestone(@PathVariable long id) {
		return milestoneMapper.milestoneToDto(milestoneService.removeAddress(id));
	}
}
