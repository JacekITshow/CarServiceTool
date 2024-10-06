import React, {useEffect, useState} from 'react';
import {InputText} from "primereact/inputtext";
import {Button} from "primereact/button";
import {Card} from "primereact/card";
import {Link} from "react-router-dom";

export default function ChangePasswordPage() {

    const [email, setEmail] = useState();

    const [isEmailCorrect, setIsEmailCorrect] = useState(false);

    useEffect(() => {
    const validateForm = () => {
        let isValid = true;
        const newErrors: {login: string, password: string} = {
            login: '',
            password: ''
        };

        console.log(email);

        // if (!formData.login) {
        //     isValid = false;
        //     newErrors.login = "Pole 'Login' jest wymagane";
        // }

        setIsEmailCorrect(isValid);
    };

    validateForm();
}, [email]);

const submitChangePassword = (e: React.FormEvent) => {
    e.preventDefault();

    // Sprawdź, czy formularz jest ważny
    // if (isFormValid) {
    //     // Wyślij dane formularza do serwera
    //     // ...
    // }
};

    return (
        <div className="flex justify-content-center">
            <Card
                className={"shadow-6 border-50 w-28rem"}>
                <label htmlFor="email" className="block text-900 font-medium mb-2">Email</label>
                <InputText
                    name="email"
                    value={email}
                    placeholder="E-mail"
                    className="w-full mb-3"
                />


                    <Button type="submit">Login</Button>
            </Card>
        </div>
    )
}
