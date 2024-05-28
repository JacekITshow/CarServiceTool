import React, {useEffect, useState} from "react";
import {useDispatch} from "react-redux";
import {ResponseLazyLoadingDataDto, TranslationDto} from "../../App.service";
import {get} from "../urlBuilder/GenericHttp";
import {UrlBuilder} from "../urlBuilder/UrlBuilder";
import {Column} from "primereact/column";
import {DataTable, DataTableSelectionSingleChangeEvent, DataTableStateEvent} from "primereact/datatable";
import {columns, getTranslationsData, initialDataTableStateEvent} from "./Translations.service";

export const Translations: React.FC = () => {

    const [translationDtos, setTranslationDtos] = useState<TranslationDto[]>();
    const [translationTotalRecords, setTranslationTotalRecords] = useState<number>(0);
    const [selectedTranslation, setSelectedTranslation] = useState<TranslationDto | null>();

    const [loading, setLoading] = useState<boolean>(false);
    const [dataTableStateEvent, setDataTableStateEvent] = useState<DataTableStateEvent>(initialDataTableStateEvent);

    const dispatch = useDispatch();

    const getTranslations = (): Promise<TranslationDto[]> => {
        return get<TranslationDto[]>(new UrlBuilder().path("translation").path("all").build());
    };

    useEffect(() => {
        loadTranslationsData();
    }, []);

    useEffect(() => {
        const fetchTranslations = async () => {
            const translationList: TranslationDto[] = await getTranslations();

            dispatch({type: "TRANSLATIONS_LOADED", translationList});
        };

        fetchTranslations();
    }, []);



    const loadTranslationsData = async () => {
        setLoading(true)
        const response: ResponseLazyLoadingDataDto<TranslationDto> = await getTranslationsData(dataTableStateEvent);
        setTranslationDtos(response.rows);
        setTranslationTotalRecords(response.totalRecords);
        setLoading(false);
    };

    const onPage = (event: DataTableStateEvent) => {
        setDataTableStateEvent(event);
    };

    const onSort = (event: DataTableStateEvent) => {
        event.filters = dataTableStateEvent.filters;
        setDataTableStateEvent(event);
    };

    const onFilter = (event: DataTableStateEvent) => {
        event['first'] = 0;
        setDataTableStateEvent(event);
    };

    const onSelectionFamilyChange = (event: DataTableSelectionSingleChangeEvent<any>) => {
        const value: TranslationDto = event.value;
        setSelectedTranslation(value);
    };

    return (
        <div className="flex">
            <h3 className={"p-3"}>Family</h3>
            <DataTable value={translationDtos} dataKey="id" className={"p-3 w-min dataTableFontSize"} rows={10} lazy
                       first={dataTableStateEvent.first} totalRecords={translationTotalRecords}
                       onPage={onPage} paginator showGridlines
                       onSort={onSort} sortMode={"single"} sortOrder={dataTableStateEvent.sortOrder} sortField={dataTableStateEvent.sortField}
                       onFilter={onFilter} filterDisplay="row" loading={loading} filterClearIcon={false}
                       selectionMode="single" onSelectionChange={onSelectionFamilyChange} selection={selectedTranslation}
            >
                {columns.map((col, i) => (
                    <Column field={col.field} sortField={col.lazyField} filterField={col.lazyField} header={col.header}
                            style={col.style} sortable={col.sortable} filter={col.filter} showFilterMenu={col.showFilterMenu}
                            align={col.align} alignHeader={col.alignHeader} hidden={col.hidden}/>
                ))}
            </DataTable>
        </div>
    );
};
