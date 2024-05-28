package pl.itshow.java.repository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itshow.java.dto.TranslationDto;
import pl.itshow.java.dto.lazyLoadingDataTable.DataTableStateEvent;
import pl.itshow.java.dto.lazyLoadingDataTable.ResponseLazyLoadingDataDto;
import pl.itshow.java.entity.Translation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void getTranslationsLazy(ResponseLazyLoadingDataDto<TranslationDto> responseLazyLoadingDataDto,
                                    final DataTableStateEvent dataTableStateEvent) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TranslationDto> cq = cb.createQuery(TranslationDto.class);


        Map<String, From<?, ?>> filterObjects = new HashMap<>();
        Root<Translation> translationRoot = cq.from(Translation.class);
        filterObjects.put("Translation", translationRoot);

        List<Predicate> predicateList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();

        cq.multiselect(
                translationRoot.get("id"),
                translationRoot.get("languageId"),
                translationRoot.get("key"),
                translationRoot.get("translation")
        );

        cq.groupBy(translationRoot.get("id"));

        applyFilterMap(filterObjects, predicateList, dataTableStateEvent);
        applySortMap(filterObjects, orderList, dataTableStateEvent);

        cq.where(cb.and(predicateList.toArray(new Predicate[0])));
        cq.orderBy(orderList);

        TypedQuery<TranslationDto> query = entityManager.createQuery(cq);

        responseLazyLoadingDataDto.setTotalRecords(query.getResultList().size());

        if (dataTableStateEvent.getFirst() >= 0) {
            query.setFirstResult(dataTableStateEvent.getFirst());
            if (dataTableStateEvent.getRows() > 0) {
                query.setMaxResults(dataTableStateEvent.getRows());
            }
        }
        responseLazyLoadingDataDto.setRows(query.getResultList());
    }
}
