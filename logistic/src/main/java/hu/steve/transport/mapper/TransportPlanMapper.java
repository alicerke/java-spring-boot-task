package hu.steve.transport.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.steve.transport.dto.TransportPlanDto;
import hu.steve.transport.model.TransportPlan;

@Mapper(componentModel = "spring")
public interface TransportPlanMapper {

	List<TransportPlanDto> transportPlanListToDto(List<TransportPlan> all);

	TransportPlanDto transportPlanToDto(TransportPlan trasportPlan);

	TransportPlan dtoToTransportPlan(TransportPlanDto sectionDto);

}
