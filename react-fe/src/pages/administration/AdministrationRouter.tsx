import React from 'react';
import {Navigate, Route, Routes} from 'react-router-dom';
import GeneralPage from "./generalPage/GeneralPage";
import TranslationsPage from "./translationsPage/TranslationsPage";
import LogsPage from "./logsPage/LogsPage";
import SettingPage from "./settingPage/SettingPage";
import RolesPage from "./rolesPage/RolesPage";
import AdministrationMainPage from "./mainPage/AdministrationMainPage";
import NotFoundPage from "../notfound/NotFoundPage";
const AdministrationRouter: React.FC = () => {
    return (
        <Routes>
            <Route path="/" element={<AdministrationMainPage/>} />
            <Route path="/general" element={<GeneralPage/>} />
            <Route path="/translations" element={<TranslationsPage/>} />
            <Route path="/logs" element={<LogsPage/>} />
            <Route path="/settings" element={<SettingPage/>} />
            <Route path="/roles" element={<RolesPage/>} />
            <Route path="/*" element={<RolesPage/>} />
            {/*<Route path="/car/:id" element={<CarProfile/>} />*/}

            {/*<Route path="*" element={ <Navigate to="/404" replace />} />*/}

            <Route path="*" element={<Navigate to="/404" />} />

        </Routes>
    );
};

export default AdministrationRouter;
