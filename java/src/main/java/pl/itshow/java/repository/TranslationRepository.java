package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.Translation;

import java.util.List;

public interface TranslationRepository extends JpaRepository<Translation, Long> {

    List<Translation> findAll();

    Translation findById(long languageId);

    List<Translation> findTranslationsByLanguageId(long languageId);
}
