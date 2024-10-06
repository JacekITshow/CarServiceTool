export class UrlBuilder {
    private url: string = "";

    value(value: any): UrlBuilder {
        this.url += `/${value}`;
        return this;
    }

    path(path: string): UrlBuilder {
        this.url += `/${path}`;
        return this;
    }

    params(params: any) {
        this.url += '?';
        this.url += Object.keys(params)
            .map(key => {
                return `${key}=${params[key]}`;
            })
            .join("&");
        return this;
    }

    build(): string {
        return this.url;
    }
}
