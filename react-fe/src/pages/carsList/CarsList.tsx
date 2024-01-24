import React from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

interface ColumnMeta {
    field: string;
    header: string;
}
export default function CarsList() {

    const products = [
        {id: 1, name: "test", cost: 1},
        {id: 2, name: "test2", cost: 2},
        {id: 3, name: "test3", cost: 3}
    ];

    const columns: ColumnMeta[] = [
        {field: 'id', header: 'id'},
        {field: 'name', header: 'Name'},
        {field: 'cost', header: 'cost'}
    ];

    return (
        <>
            <div className={''}></div>
        <div className="card">
            <DataTable value={products} tableStyle={{ minWidth: '50rem' }}>
                {columns.map((col, i) => (
                    <Column key={col.field} field={col.field} header={col.header} />
                ))}
            </DataTable>
        </div>
        </>
    );
}
