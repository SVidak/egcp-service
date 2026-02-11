package rs.erste.egcpservice.mapper;


import org.springframework.stereotype.Component;
import rs.erste.egcpservice.dto.EGCPEventDTO;
import rs.erste.egcpservice.model.egcp.EGCPEvent;

@Component
public class EGCPMapper {

    public EGCPEvent toEGCPEvent(EGCPEventDTO egcpEventDTO) {
        return new EGCPEvent(egcpEventDTO.apiVersion(), egcpEventDTO.cardID(), egcpEventDTO.customerId(), egcpEventDTO.acsAuthenticationData(), egcpEventDTO.acsCardholderData());

    }

    public EGCPEventDTO toEGCPEventDTO(EGCPEvent egcpEvent) {
        return new EGCPEventDTO(egcpEvent.getApiVersion(), egcpEvent.getCardID(), egcpEvent.getCustomerId(), egcpEvent.getAcsAuthenticationData(), egcpEvent.getAcsCardholderData());
    }
}
