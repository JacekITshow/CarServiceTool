package pl.itshow.java.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itshow.java.dto.TranslationDto;
import pl.itshow.java.entity.Translation;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslationDaoImpl extends AbstractDaoImpl implements TranslationDao {

    private TranslationRepository translationRepository;

    @Override
    public void createTranslation(TranslationDto translationDto) {
        final Translation translation = Translation.builder()
                .languageId(translationDto.getLanguageId())
                .key(translationDto.getKey())
                .translation(translationDto.getTranslation())
                .build();
        logger.debug("Build translation entity.");
        try {
            translationRepository.save(translation);
            logger.debug("Create translation completed successfully.");
        } catch (Exception e) {
            logger.error("Create translation failure with data: " + translationDto.toString(), e);
            throw new RuntimeException("Create translation failure");
        }
    }

    @Override
    public void createTranslations(List<TranslationDto> translationDtoList) {
        translationDtoList.forEach(this::createTranslation);
    }

    @Override
    public void updateTranslation(TranslationDto translationDto) {
        Translation translation = translationRepository.findById(translationDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Translation not found. Delete completed failure."));
        translation = mapTranslationDtoToTranslation(translation, translationDto);
        translationRepository.save(translation);
    }

    @Override
    public void deleteTranslation(Long translationId) {
        Translation translation = translationRepository.findById(translationId)
                .orElseThrow(() -> new IllegalArgumentException("Translation not found. Delete completed failure."));
        translationRepository.delete(translation);
    }

    private Translation mapTranslationDtoToTranslation(Translation translation, TranslationDto translationDto) {
        translation.setLanguageId(translationDto.getLanguageId());
        translation.setKey(translation.getKey());
        translation.setTranslation(translation.getTranslation());

        return translation;
    }
}
