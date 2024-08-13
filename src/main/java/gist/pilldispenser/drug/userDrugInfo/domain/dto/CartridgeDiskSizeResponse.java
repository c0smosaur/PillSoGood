package gist.pilldispenser.drug.userDrugInfo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartridgeDiskSizeResponse {

    private String diskSize;
    private String drugShape;
}
