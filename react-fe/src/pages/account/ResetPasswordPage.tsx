import React, {useEffect, useState} from 'react';
import {InputText} from "primereact/inputtext";
import {Button} from "primereact/button";
import {Card} from "primereact/card";
import {get, post} from "../../common/urlBuilder/GenericHttp";
import {UrlBuilder} from "../../common/urlBuilder/UrlBuilder";

export default function ResetPasswordPage() {

    const [email, setEmail] = useState<string>("");

    const [isEmailCorrect, setIsEmailCorrect] = useState(false);

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    useEffect(() => {
        let isValid = true;
        if (!emailRegex.test(email)) {
            isValid = false;
        }
        setIsEmailCorrect(isValid);
    }, [email]);

    const resetPassword = () => {
        if (isEmailCorrect) {
            post<boolean>(new UrlBuilder().path("api").path("user").path("reset").value(email).build());
        }
    };

    return (
        <div className="flex justify-content-center">
            <Card
                className={"shadow-6 border-50 w-28rem"}>
                <label htmlFor="email" className="block text-900 font-medium mb-2">Email</label>
                <InputText
                    name="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    placeholder="E-mail"
                    className="w-full mb-3 mr-auto"
                />
                <Button className="ml-auto flex" disabled={!isEmailCorrect} onClick={resetPassword}>Reset Password</Button>
            </Card>
        </div>
    )
}
