package id.holigo.services.holigoshipservice.web.mappers;

import id.holigo.services.holigoshipservice.domain.Inquiry;
import id.holigo.services.holigoshipservice.web.model.InquiryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface InquiryMapper {

    @Mapping(target = "userId", ignore = true)
    InquiryDto inquiryToInquiryDto(Inquiry inquiry);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Inquiry inquiryDtoToInquiry(InquiryDto inquiryDto);
}
