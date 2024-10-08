import React, {FC, useEffect, useState} from 'react';
import {Button} from "primereact/button";
import {Checkbox} from "primereact/checkbox";
import {InputText} from "primereact/inputtext";
import {getUserData, CustomerDto} from "./CustomerProfile.service";

interface CustomerProfileProps {
    customerId: number;
}

    export default function CustomerProfile() {

    const [checked, setChecked] = useState(false);
    const [customerDto, setUserDto] = useState<CustomerDto>();

    useEffect(() => {
        getUserDto(1);
    }, []);

    const getUserDto = async (userId: number): Promise<void> => {
        const userDto: CustomerDto = await getUserData(userId);
        setUserDto(userDto);
    };
    return (

        <div className="flex align-items-center justify-content-center">
            <div className="surface-card p-4 shadow-2 border-round w-full lg:w-6">
                <div className="text-center mb-5">
                    <div className="text-900 text-3xl font-medium mb-3">Welcome Back</div>
                    <span className="text-600 font-medium line-height-3">{customerDto?.firstName + "" + customerDto?.surname}</span>
                    <a className="font-medium no-underline ml-2 text-blue-500 cursor-pointer">Create today!</a>
                </div>

                <div>
                    <label htmlFor="email" className="block text-900 font-medium mb-2">Email</label>
                    <InputText id="email" type="text" placeholder="Email address" className="w-full mb-3"/>

                    <label htmlFor="password" className="block text-900 font-medium mb-2">Password</label>
                    <InputText id="password" type="password" placeholder="Password" className="w-full mb-3"/>

                    <div className="flex align-items-center justify-content-between mb-6">
                        <div className="flex align-items-center">
                            <Checkbox id="rememberme" onChange={e => setChecked(!checked)} checked={checked} className="mr-2"/>
                            <label htmlFor="rememberme" className="text-900">Remember me</label>
                        </div>
                        <a className="font-medium no-underline ml-2 text-blue-500 text-right cursor-pointer">Forgot your password?</a>
                    </div>

                    <Button label="Sign In" icon="pi pi-user" className="w-full"/>
                </div>
            </div>
        </div>

    );
}
