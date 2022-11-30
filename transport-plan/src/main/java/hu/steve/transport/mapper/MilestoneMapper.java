package hu.steve.transport.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.steve.transport.dto.MilestoneDto;
import hu.steve.transport.model.Milestone;

@Mapper(componentModel = "spring")
public interface MilestoneMapper {

	List<MilestoneDto> milestoneListToDto(List<Milestone> all);

//	@Mapping(target = "address", ignore = true)
	MilestoneDto milestoneToDto(Milestone milestone);

	Milestone dtoToMilestone(MilestoneDto milestoneDto);

}
