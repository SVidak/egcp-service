package rs.erste.egcpservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import rs.erste.egcpservice.model.egcp.AcsAuthenticationData;
import rs.erste.egcpservice.model.egcp.AcsCardholderData;

public record EGCPEventDTO(@NotBlank String apiVersion, @NotBlank String cardID, @NotNull Long customerId, @NotNull @Valid AcsAuthenticationData acsAuthenticationData, @NotNull @Valid AcsCardholderData acsCardholderData) {
}
