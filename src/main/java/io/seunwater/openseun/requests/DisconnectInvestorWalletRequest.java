package io.seunwater.openseun.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisconnectInvestorWalletRequest {

    private UUID investorId;
    private UUID walletId;

}