package pl.itshow.java.entity.i18;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "translation")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationPo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "key")
    private String key;

    @Column(name = "translation")
    private String translation;
}
