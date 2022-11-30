package hu.steve.transport.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
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
import hu.steve.transport.dto.AddressSearchDto;
import hu.steve.transport.mapper.AddressMapper;
import hu.steve.transport.model.Address;
import hu.steve.transport.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	private AddressService addressService;
	private AddressMapper addressMapper;
	
	public AddressController(AddressService addressService,
			AddressMapper addressMapper) {
		super();
		this.addressService = addressService;
		this.addressMapper = addressMapper;
	}
	
	@GetMapping
	public List<AddressDto> getAllAddress(){
		return addressMapper.addressListToDto(addressService.getAll());
	}
	
	@GetMapping("/{id}")
	public AddressDto getaddressById(@PathVariable long id) {
		Address address = addressService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return addressMapper.addressToDto(address);
	}
	
	@PostMapping
	public ResponseEntity<AddressDto> createAddress(@RequestBody @Valid AddressDto addressDto) {
		if(addressDto.getId() != null)
			return ResponseEntity.badRequest().build();
		Address address = addressService.save(addressMapper.dtoToAddress(addressDto));
		return ResponseEntity.ok(addressMapper.addressToDto(address));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> updateAddress(@PathVariable long id, @RequestBody @Valid AddressDto addressDto) {
		if(addressDto.getId() != null && id != addressDto.getId())
			return ResponseEntity.badRequest().build();		
		addressDto.setId(id);
		Address updateAddress = addressService.update(addressMapper.dtoToAddress(addressDto));
		return updateAddress == null ? ResponseEntity.notFound().build() 
				: ResponseEntity.ok(addressMapper.addressToDto(updateAddress));		
	}
	
	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable long id) {
		addressService.delete(id);
	}	
	
	@PostMapping("/search")
	public ResponseEntity<List<AddressDto>> findByAddress(@RequestBody AddressSearchDto addressSearch, Pageable pageable) {
		if(!addressSearch.equals(null)) {
			Page<Address> addressPage = addressService.findAddressByExample(addressSearch, pageable);			
			HttpHeaders httpHeaders = new HttpHeaders();
		    httpHeaders.add("X-Total-Count", String.valueOf(addressPage.getTotalElements()));
		    return new ResponseEntity<>(addressMapper.addressListToDto(addressPage.getContent()), httpHeaders, HttpStatus.OK);
		}			
		else
			return ResponseEntity.badRequest().build();
	}	
	
}
