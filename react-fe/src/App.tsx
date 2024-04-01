import React, {useEffect, useRef, useState} from 'react';
import './App.css';
import {BrowserRouter} from "react-router-dom";

import 'primereact/resources/themes/lara-light-green/theme.css';
import 'primeicons/primeicons.css';
import 'primeflex/primeflex.css';
import Navigation from "./components/navigation/Navigation";
import {Toast} from "primereact/toast";
import {userDataDTO} from "./AppDTO";
import MainRouter from "./MainRouter";
import {TestInfo} from "./pages/TestInfo";
import Translations from "./common/translations/Translations";
import {UserDto} from "./pages/usersList/UsersList.service";
import {get} from "./common/urlBuilder/GenericHttp";
import {UrlBuilder} from "./common/urlBuilder/UrlBuilder";
import {TranslationDto} from "./App.service";

function App() {

    const toast:React.RefObject<Toast> = useRef<Toast>(null);

    const userData: userDataDTO = {
        id: 1,
        login: "jsmith",
        firstName: "John",
        surname: "Smith",
        gender: "male",
        email: "example@mail.com",
        phoneNumber: 666777888,
        birthday: new Date(2023,12,20),
        description: "test description"
    };

    const [translations, setTranslations] = useState<TranslationDto[]>();

    const getTranslations = (): Promise<TranslationDto[]> => {
        return get<TranslationDto[]>(new UrlBuilder().path("translation").path("all").build());
    };

    const setNewTranslations = async () => {
        const translationList: TranslationDto[] = await getTranslations();
        setTranslations(translationList);
    };

    useEffect(() => {
        setNewTranslations();
    }, []);

    return (
        <BrowserRouter>
            {/*<Translations />*/}
            <Navigation userData={userData}/>
            <div className="mt-5">
                <MainRouter />
            </div>
            <TestInfo />
        </BrowserRouter>
    );
}

export default App;
