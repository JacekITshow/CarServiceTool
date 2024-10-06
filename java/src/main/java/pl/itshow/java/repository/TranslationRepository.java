package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.i18.TranslationPo;

import java.util.List;

public interface TranslationRepository extends JpaRepository<TranslationPo, Long> {

    List<TranslationPo> findAll();

    TranslationPo findById(long languageId);

    List<TranslationPo> findTranslationsByLanguageId(long languageId);
}
