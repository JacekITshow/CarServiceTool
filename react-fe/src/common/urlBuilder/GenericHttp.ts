import axios from "axios";

export const httpRequestStarted: string = "httpRequestStarted";
export const httpRequestEnded: string = "httpRequestEnded";

const baseUrl: string = "http://localhost:8080";

export interface HttpEvent {
    url: string;
}

export const getHttpRequestStartedEvent = (url: string): CustomEvent<HttpEvent> => {
    const httpEvent: HttpEvent = {
        url
    };
    return new CustomEvent(httpRequestStarted, {detail: httpEvent});
};


export const getHttpRequestEndedEvent = (url: string): CustomEvent<HttpEvent> => {
    const httpEvent: HttpEvent = {
        url
    };
    return new CustomEvent(httpRequestEnded, {detail: httpEvent});
};


export const getBaseURL = (): string => {
    return baseUrl;
};

const create = axios.create({
    baseURL: getBaseURL()
});

export const get = async <T>(url: string, params?: any): Promise<T> => {
    window.dispatchEvent((getHttpRequestStartedEvent(url)));
    const response = await create.get<T>(url, {params: params, withCredentials: true})
        .finally(() => {
            window.dispatchEvent(getHttpRequestEndedEvent(url))
        })
    return response.data;
};

export const post = async <T>(url: string, params?: any): Promise<T> => {
    window.dispatchEvent((getHttpRequestStartedEvent(url)));
    const response = await create.post<T>(url, {params: params, withCredentials: true})
        .finally(() => {
            window.dispatchEvent(getHttpRequestEndedEvent(url))
        })
    return response.data;
};
