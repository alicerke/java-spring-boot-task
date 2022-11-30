package hu.steve.transport.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.steve.transport.dto.TransportPlanDto;
import hu.steve.transport.model.TransportPlan;

@Mapper(componentModel = "spring")
public interface TransportPlanMapper {

	List<TransportPlanDto> transportPlanListToDto(List<TransportPlan> all);

	@Mapping(target = "sections.fromMilestone.address", ignore = true)
	@Mapping(target = "sections.toMilestone.address", ignore = true)
	TransportPlanDto transportPlanToDto(TransportPlan trasportPlan);

	TransportPlan dtoToTransportPlan(TransportPlanDto transportPlanDto);

}
