import React, { useState, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {TranslationDto} from "../../App.service";
import {get} from "../urlBuilder/GenericHttp";
import {UrlBuilder} from "../urlBuilder/UrlBuilder";

const Translations: React.FC = () => {
    const dispatch = useDispatch();

    const getTranslations = (): Promise<TranslationDto[]> => {
        return get<TranslationDto[]>(new UrlBuilder().path("translation").path("all").build());
    };

    useEffect(() => {
        const fetchTranslations = async () => {
            const translationList: TranslationDto[] = await getTranslations();

            dispatch({ type: "TRANSLATIONS_LOADED", translationList });
        };

        fetchTranslations();
    }, []);

    return (
        <>
        </>
    );
};

export default Translations;
