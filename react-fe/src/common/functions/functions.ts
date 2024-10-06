
export const isUndefined = (value: unknown) => {
    return typeof value === "undefined";
}

export const isNumber = (value: unknown) => {
    return typeof value === "number";
}

export const isNull = (value: unknown) => {
    return value == null;
}

export const isNotEmpty = (value: unknown): boolean => {
    if (value == null) {
        return false;
    }

    if (typeof value === 'string') {
        return value.trim().length > 0;
    }

    if (Array.isArray(value)) {
        return value.length > 0;
    }

    if (value instanceof Map || value instanceof Set) {
        return value.size > 0;
    }

    if (typeof value === 'object') {
        return Object.keys(value).length > 0;
    }

    return true; // for variables like booleans or numbers is default as true
};
