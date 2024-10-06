import React from 'react';
import {Route, Routes} from 'react-router-dom';
import Home from "./pages/home/Home";
import NotFoundPage from "./pages/notfound/NotFoundPage";
import ContactPage from "./pages/contact/ContactPage";
import CustomersList from "./pages/customersList/CustomersList";
import CarsList from "./pages/carsList/CarsList";
import CarProfile from "./pages/carProfile/CarProfile";
import Calendar from "./pages/calendar/Calendar";
import CustomerProfile from "./pages/customerProfile/CustomerProfile";
import Administration from "./pages/administration/Administration";
import LoginPage from "./pages/account/LoginPage";
import ResetPasswordPage from "./pages/account/ResetPasswordPage";
import ChangePasswordPage from "./pages/account/ChangePasswordPage";

const MainRouter: React.FC = () => {
    return (
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/contact" element={<ContactPage/>}/>
            <Route path="/usersList" element={<CustomersList/>}/>
            <Route path="/carsList" element={<CarsList/>}/>
            <Route path="/calendar" element={<Calendar/>}/>
            <Route path="/car/:id" element={<CarProfile/>}/>
            <Route path="/userProfile/:id" element={<CustomerProfile/>}/>
            <Route path="/administration" element={<Administration/>}/>
            <Route path="/administration/*" element={<Administration/>}/>

            <Route path="/login" element={<LoginPage/>}/>
            <Route path="/resetpassword" element={<ResetPasswordPage/>}/>
            <Route path="/changepassword" element={<ChangePasswordPage/>}/>

            <Route path="/404" element={<NotFoundPage/>}/>
            <Route path="*" element={<NotFoundPage/>}/> {/* Fallback for all other routes */}
        </Routes>
    );
};

export default MainRouter;
