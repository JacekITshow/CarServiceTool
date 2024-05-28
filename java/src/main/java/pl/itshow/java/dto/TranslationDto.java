package pl.itshow.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5087457987080272447L;

    private Long id;

    private Long languageId;

    private String key;

    private String translation;
}
