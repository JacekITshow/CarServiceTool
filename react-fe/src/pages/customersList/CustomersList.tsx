import React, {useEffect, useState} from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import {get} from "../../common/urlBuilder/GenericHttp";
import {UrlBuilder} from "../../common/urlBuilder/UrlBuilder";
import {Button} from "primereact/button";
import {ColumnMeta, CustomerDto} from "./CustomersList.service";


export default function CustomersList() {

    const [customers, setUsers] = useState<CustomerDto[]>();

    const getUsers = (): Promise<CustomerDto[]> => {
        return get<CustomerDto[]>(new UrlBuilder().path("api").path("user").path("all").build());
    };

    const setNewInfo = async () => {
        const usersList: CustomerDto[] = await getUsers();
        setUsers(usersList);
    };

    useEffect(() => {
        setNewInfo();
    }, []);

    const columns: ColumnMeta[] = [
        {field: 'id', header: 'id'},
        {field: 'firstName', header: 'First Name'},
        {field: 'lastName', header: 'Last Name'},
        {field: 'gender', header: 'Gender'},
        {field: 'email', header: 'Email'},
        {field: 'phoneNumber', header: 'Phone Number'},
        {field: 'birthdate', header: 'Birthdate'},
        {field: 'description', header: 'Description'}
    ];

    return (
        <div className="card">
            <Button onClick={setNewInfo}>current time</Button>
            <DataTable value={customers} tableStyle={{ minWidth: '50rem' }}>
                {columns.map((col, i) => (
                    <Column key={col.field} field={col.field} header={col.header} />
                ))}
            </DataTable>
        </div>
    );
}
