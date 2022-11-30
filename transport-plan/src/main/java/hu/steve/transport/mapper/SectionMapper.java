package hu.steve.transport.mapper;

import java.util.List;

import javax.validation.Valid;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.steve.transport.dto.SectionDto;
import hu.steve.transport.model.Section;

@Mapper(componentModel = "spring")
public interface SectionMapper {

	List<SectionDto> sectionListToDto(List<Section> all);

	@Mapping(target = "fromMilestone.address", ignore = true)
	@Mapping(target = "toMilestone.address", ignore = true)
	SectionDto sectionToDto(Section section);

	Section dtoToSection(@Valid SectionDto sectionDto);

}
