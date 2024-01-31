import React, {useState} from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import {get} from "../../common/urlBuilder/GenericHttp";
import {UrlBuilder} from "../../common/urlBuilder/UrlBuilder";
import {Button} from "primereact/button";

interface ColumnMeta {
    field: string;
    header: string;
}

interface CustomerDto {
    id: number;
    first_name: string;
    surname: string;
    gender: string;
    email: string;
    phone_number: string;
    birthdate: Date;
    description: string;
}
export default function UsersList() {

    const [customer, setCustomer] = useState<CustomerDto[]>();

    const getInfo = (): Promise<CustomerDto[]> => {
        return get<CustomerDto[]>(new UrlBuilder().path("test").path("male").build());
    };

    const setNewInfo = async () => {
        const customersList: CustomerDto[] = await getInfo();
        setCustomer(customersList);
    };

    const products = [
        {id: 1, name: "test", cost: 1},
        {id: 2, name: "test2", cost: 2},
        {id: 3, name: "test3", cost: 3}
    ];

    const columns: ColumnMeta[] = [
        {field: 'id', header: 'id'},
        {field: 'first_name', header: 'First Name'},
        {field: 'surname', header: 'Surname'},
        {field: 'gender', header: 'Gender'},
        {field: 'email', header: 'Email'},
        {field: 'phone_number', header: 'Phone Number'},
        {field: 'birthdate', header: 'Birthdate'},
        {field: 'description', header: 'Description'}
    ];

    return (
        <div className="card">
            <Button onClick={setNewInfo}>current time</Button>
            <DataTable value={customer} tableStyle={{ minWidth: '50rem' }}>
                {columns.map((col, i) => (
                    <Column key={col.field} field={col.field} header={col.header} />
                ))}
            </DataTable>
        </div>
    );
}
