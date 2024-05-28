import {ColumnMeta, ResponseLazyLoadingDataDto, TranslationDto} from "../../App.service";
import {DataTableStateEvent} from "primereact/datatable";
import {UrlBuilder} from "../urlBuilder/UrlBuilder";
import {post, postData} from "../urlBuilder/GenericHttp";

export const initialDataTableStateEvent: DataTableStateEvent = {
    first: 0,
    rows: 10,
    page: 0,
    sortField: '',
    sortOrder: null,
    multiSortMeta: [],
    filters: {}
};
export const columns: ColumnMeta[] = [
    {
        field: 'languageId',
        lazyField: 'translation.languageId',
        header: 'Language',
        style: {width: '17rem'},
        sortable: true,
        filter: true,
        showFilterMenu: false
    },
    {
        field: 'key',
        lazyField: 'translation.key',
        header: 'Key',
        style: {width: '17rem'},
        sortable: true,
        filter: true,
        showFilterMenu: false
    },
    {
        field: 'translation',
        lazyField: 'Translation.translation',
        header: 'Translation',
        style: {width: '17rem'},
        sortable: true,
        filter: true,
        showFilterMenu: false
    },
];

export const getTranslationsData = (dataTableStateEvent: DataTableStateEvent): Promise<ResponseLazyLoadingDataDto<TranslationDto>> => {
    const data = {
        first: dataTableStateEvent?.first,
        rows: dataTableStateEvent?.rows,
        page: dataTableStateEvent?.page,
        totalPages: dataTableStateEvent?.totalPages,
        sortField: dataTableStateEvent?.sortField,
        sortOrder: dataTableStateEvent?.sortOrder,
        multiSortMeta: dataTableStateEvent?.multiSortMeta,
        filters: dataTableStateEvent?.filters
    }

    return postData<ResponseLazyLoadingDataDto<TranslationDto>>(new UrlBuilder().path("mainprocess").path("lazy").build(), data);
};
