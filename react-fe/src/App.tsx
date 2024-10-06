import React, {useRef} from 'react';
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

function App() {

    const toast: React.RefObject<Toast> = useRef<Toast>(null);

    const userData: userDataDTO = {
        id: 1,
        login: "jsmith",
        firstName: "John",
        surname: "Smith",
        gender: "male",
        email: "example@mail.com",
        phoneNumber: 666777888,
        birthday: new Date(2023, 12, 20),
        description: "test description"
    };

    return (
        <BrowserRouter>
            <Navigation userData={userData}/>
            <div className="mt-5 xl:w-10 mx-auto">
                <MainRouter/>
            </div>
        </BrowserRouter>
    );
}

export default App;
