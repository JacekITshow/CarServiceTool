import {get} from "../../common/urlBuilder/GenericHttp";
import {UrlBuilder} from "../../common/urlBuilder/UrlBuilder";

export interface ColumnMeta {
    field: string;
    header: string;
}

export interface CustomerDto {
    id: number;
    firstName: string;
    surname: string;
    gender: string;
    email: string;
    phone_number: string;
    birthdate: Date;
    description: string;
}

export const getUserData = (userId: number): Promise<CustomerDto> => {
    return get<CustomerDto>(new UrlBuilder().path("api").path("user").value(userId).build());
};

