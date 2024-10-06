export interface ColumnMeta {
    field: string;
    header: string;
}

export interface CustomerDto {
    id: number;
    first_name: string;
    last_name: string;
    gender: string;
    email: string;
    phone_number: string;
    birthdate: Date;
    description: string;
}
