package hu.steve.transport.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.steve.transport.dto.AddressDto;
import hu.steve.transport.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	List<AddressDto> addressListToDto(List<Address> all);

	AddressDto addressToDto(Address address);

	Address dtoToAddress(AddressDto addressDto);
}
