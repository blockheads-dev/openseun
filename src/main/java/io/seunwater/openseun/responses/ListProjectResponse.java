package io.seunwater.openseun.responses;

import io.seunwater.openseun.common.ProjectStatus;
import io.seunwater.openseun.common.WalletStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ListProjectResponse {

    private UUID projectId;

    private String name;

    private ProjectStatus projectStatus;

    private WalletStatus walletStatus;

    private Double totalBenefitsReceived;
}