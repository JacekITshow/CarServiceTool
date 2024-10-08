package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.itshow.java.dto.TranslationDto;
import pl.itshow.java.dto.lazyLoadingDataTable.DataTableStateEvent;
import pl.itshow.java.dto.lazyLoadingDataTable.ResponseLazyLoadingDataDto;
import pl.itshow.java.entity.i18.TranslationPo;
import pl.itshow.java.repository.TranslationDao;
import pl.itshow.java.repository.TranslationRepository;
import pl.itshow.java.service.TranslationService;

import java.util.List;

@RestController
@RequestMapping("/api/translation")
public class TranslationController {

    @Autowired
    TranslationRepository translationRepository;

    @Autowired
    TranslationDao translationDao;

    TranslationService translationService;

    @GetMapping("/all")
    public List<TranslationPo> getAllTranslations() {
        return translationRepository.findAll();
    }

    @GetMapping("/language/{langaugeId}")
    public List<TranslationPo> getAllTranslations(@PathVariable int langaugeId) {
        return translationRepository.findTranslationsByLanguageId(langaugeId);
    }

    @PostMapping("/createTranslation")
    public void createTranslation(TranslationDto translationDto) {
        translationDao.createTranslation(translationDto);
    }

    @PostMapping("/createTranslations")
    public void createTranslations(List<TranslationDto> translationDtos) {
        translationDao.createTranslations(translationDtos);
    }

    @PostMapping("/lazy")
    public ResponseLazyLoadingDataDto<TranslationDto> getTranslationsLazy(@RequestBody DataTableStateEvent dataTableStateEvent) {
        return translationService.getTranslationLazy(dataTableStateEvent);
    }
}
