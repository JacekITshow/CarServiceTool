import axios from "axios";

/* Here you can define for what address you want to connect when you run react app in IDE */
const baseUrl: string = window.location.origin == "http://localhost:3000" ? "http://localhost:9080" : window.location.origin;

export const getBaseURL = (): string => {
    return baseUrl;
};

const create = axios.create({
    baseURL: getBaseURL()
});

export const get = async <T>(url: string, params?: any): Promise<T> => {
    const response = await create.get<T>(url, {params: params});
    return response.data;
};

export const post = async <T>(url: string, params?: any): Promise<T> => {
    const response = await create.post<T>(url, {params: params});
    return response.data;
};

export const postData = async <T>(url: string, data?: any): Promise<T> => {
    const response = await create.post<T>(url, data);
    return response.data;
};
