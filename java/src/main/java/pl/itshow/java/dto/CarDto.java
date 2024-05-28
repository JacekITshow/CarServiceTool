package pl.itshow.java.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5087457987080272447L;

    private Long id;

    private Long customerId;

    private String plate;

    private String plateCountry;

    private String vin;

    private Long brand;

    private Date model;

    private String modelCode;

}
