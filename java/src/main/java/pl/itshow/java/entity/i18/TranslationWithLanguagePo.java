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
public class TranslationWithLanguagePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguagePo language;

    @Column(name = "key")
    private String key;

    @Column(name = "translation")
    private String translation;
}
