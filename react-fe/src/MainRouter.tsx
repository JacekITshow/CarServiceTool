import React from 'react';
import {Navigate, Route, Routes} from 'react-router-dom';
import Home from "./pages/home/Home";
import NotFoundPage from "./pages/notfound/NotFoundPage";
import ContactPage from "./pages/contact/ContactPage";
import UsersList from "./pages/usersList/UsersList";
import CarsList from "./pages/carsList/CarsList";
import CarProfile from "./pages/carProfile/CarProfile";
import Calendar from "./pages/calendar/Calendar";
import UserProfile from "./pages/userProfile/UserProfile";
const MainRouter: React.FC = () => {
    return (
        <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/contact" element={<ContactPage/>} />
            <Route path="/usersList" element={<UsersList/>} />
            <Route path="/carsList" element={<CarsList/>} />
            <Route path="/calendar" element={<Calendar/>} />
            <Route path="/car/:id" element={<CarProfile/>} />
            <Route path="/userProfile/:id" element={<UserProfile />}  />

            <Route path="/404" element={ <NotFoundPage /> } />
            <Route path="*" element={ <Navigate to="/404" replace />} />
        </Routes>
    );
};

export default MainRouter;
