

export interface ResponseLazyLoadingDataDto<T extends object> {
    totalRecords: number,
    rows: T[]
}

export interface ColumnMeta {
    field: string;
    lazyField?: string;
    header: string;
    align?: 'left' | 'right' | 'center' | undefined | null;
    alignHeader?: 'left' | 'right' | 'center' | undefined | null;
    style?: React.CSSProperties;
    sortable?: boolean;
    filter?: boolean;
    showFilterMenu?: boolean;
    hidden?: boolean;
}
