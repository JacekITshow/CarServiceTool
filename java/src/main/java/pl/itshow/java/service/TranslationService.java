package pl.itshow.java.service;

import pl.itshow.java.dto.TranslationDto;
import pl.itshow.java.dto.lazyLoadingDataTable.DataTableStateEvent;
import pl.itshow.java.dto.lazyLoadingDataTable.ResponseLazyLoadingDataDto;
import pl.itshow.java.repository.TranslationDao;

public class TranslationService {

private TranslationDao translationDao;

    public ResponseLazyLoadingDataDto<TranslationDto> getTranslationLazy(final DataTableStateEvent dataTableStateEvent) {
        ResponseLazyLoadingDataDto<TranslationDto> responseLazyLoadingDataDto = new ResponseLazyLoadingDataDto<TranslationDto>();

        translationDao.getTranslationsLazy(responseLazyLoadingDataDto, dataTableStateEvent);

        return responseLazyLoadingDataDto;
    }
}
