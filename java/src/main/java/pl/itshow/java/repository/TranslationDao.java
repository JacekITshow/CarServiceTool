package pl.itshow.java.repository;

import pl.itshow.java.dto.TranslationDto;

import java.util.List;

public interface TranslationDao {

    void createTranslation(TranslationDto translationDto);

    void createTranslations(List<TranslationDto> translationDtoList);

    void updateTranslation(TranslationDto translationDto);

    void deleteTranslation(Long translationId);
}
