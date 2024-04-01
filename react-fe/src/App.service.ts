
export interface TranslationDto {
    id: number,
    language: LanguageDto,
    key: string,
    translation: string
}

export interface LanguageDto {
    id: number,
    name: string
}
