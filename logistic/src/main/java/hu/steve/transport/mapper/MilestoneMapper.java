package hu.steve.transport.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.steve.transport.dto.MilestoneDto;
import hu.steve.transport.model.Milestone;

@Mapper(componentModel = "spring")
public interface MilestoneMapper {

	MilestoneDto milestoneToDto(Milestone milestone);

	Milestone dtoToMilestone(MilestoneDto addressDto);

	List<MilestoneDto> milestoneListToDto(List<Milestone> all);

}
