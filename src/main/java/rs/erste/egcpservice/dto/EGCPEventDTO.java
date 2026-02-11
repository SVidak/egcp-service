package rs.erste.egcpservice.dto;

import rs.erste.egcpservice.model.egcp.AcsAuthenticationData;
import rs.erste.egcpservice.model.egcp.AcsCardholderData;

public record EGCPEventDTO(String apiVersion, String cardID, Long customerId, AcsAuthenticationData acsAuthenticationData, AcsCardholderData acsCardholderData) {
}
