package hu.steve.transport.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.steve.transport.dto.SectionDto;
import hu.steve.transport.model.Section;

@Mapper(componentModel = "spring")
public interface SectionMapper {

	List<SectionDto> sectionListToDto(List<Section> all);

	SectionDto sectionToDto(Section section);

	Section dtoToSection(SectionDto sectionDto);

}
