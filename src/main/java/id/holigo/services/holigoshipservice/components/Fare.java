package id.holigo.services.holigoshipservice.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.holigo.services.common.model.FareDetailDto;
import id.holigo.services.common.model.FareDto;
import id.holigo.services.holigoshipservice.config.FeeConfig;
import id.holigo.services.holigoshipservice.services.fare.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.math.BigDecimal;

@Component
public class Fare {
    private FareService fareService;

    @Autowired
    public void setFareService(FareService fareService) {
        this.fareService = fareService;
    }

    public FareDto getFare(Long userId) {
        FareDetailDto fareDetailDto = FareDetailDto.builder()
                .userId(userId)
                .productId(2)
                .nraAmount(FeeConfig.NRA_AMOUNT)
                .ntaAmount(BigDecimal.valueOf(0.00)).build();
        FareDto fareDto;
        try {
            fareDto = fareService.getFareDetail(fareDetailDto);
        } catch (JMSException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return fareDto;
    }
}
