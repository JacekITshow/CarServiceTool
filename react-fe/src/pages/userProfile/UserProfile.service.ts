import {get} from "../../common/urlBuilder/GenericHttp";
import {UrlBuilder} from "../../common/urlBuilder/UrlBuilder";

export interface ColumnMeta {
    field: string;
    header: string;
}

export interface UserDto {
    id: number;
    login: string;
    first_name: string;
    last_name: string;
    gender: string;
    email: string;
    phone_number: string;
    birthdate: Date;
    description: string;
}

export const getUserData = (userId: number): Promise<UserDto> => {
    return get<UserDto>(new UrlBuilder().path("user").value(userId).build());
};

