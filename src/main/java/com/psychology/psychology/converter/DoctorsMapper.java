package com.psychology.psychology.converter;

import com.psychology.psychology.controller.dto.DoctorDto;
import com.psychology.psychology.domain.Doctor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author andrew.maksimovich
 */
@Component
public class DoctorsMapper extends AbstractConverter<Doctor, DoctorDto> {

    protected DoctorsMapper(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    protected Converter<Doctor, DoctorDto> getPostConverter() {
        return mappingContext -> {
            return mappingContext.getDestination();
        };
    }
}
