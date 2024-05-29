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

    build(): string {
        return this.url;
    }
}
