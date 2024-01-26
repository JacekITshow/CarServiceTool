import React, {useState} from 'react';
import {get} from "../common/urlBuilder/GenericHttp";
import {UrlBuilder} from "../common/urlBuilder/UrlBuilder";
import {Button} from "primereact/button";

export const TestInfo: React.FC = () => {

    const [info, setInfo] = useState<string>();

    const getInfo = (): Promise<string> => {
        return get<string>(new UrlBuilder().path("info").build());
    };

    const setNewInfo = async () => {
        const newInfo: string = await getInfo();
        setInfo(newInfo);
    };

    return (
        <div>
            <Button onClick={setNewInfo}>current time</Button>
            <h1>{info} </h1>
        </div>
    );
};
