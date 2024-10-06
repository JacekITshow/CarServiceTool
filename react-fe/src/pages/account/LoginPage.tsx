import React, {useEffect, useState} from 'react';
import {InputText} from "primereact/inputtext";
import {Button} from "primereact/button";
import {Card} from "primereact/card";
import {Link} from "react-router-dom";

export default function LoginPage() {

    const [formData, setFormData] = useState({
        email: "",
        password: ""
    });

    const [errors, setErrors] = useState({
        email: "",
        password: ""
    });

    const [isFormValid, setIsFormValid] = useState(false);

    useEffect(() => {
        const validateForm = () => {
            let isValid = true;
            const newErrors: { email: string, password: string } = {
                email: '',
                password: ''
            };

            if (!formData.email) {
                isValid = false;
                newErrors.email = "Pole 'Email' jest wymagane";
            }

            setErrors(newErrors);
            setIsFormValid(isValid);
        };

        validateForm();
    }, [formData]);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();

        // Sprawdź, czy formularz jest ważny
        if (isFormValid) {
            // Wyślij dane formularza do serwera
            // ...
        }
    };

    return (
        <div className="flex justify-content-center">
            <Card
                className={"shadow-6 border-50 w-28rem"}>
                <label htmlFor="email" className="block text-900 font-medium mb-2">Email</label>
                <InputText
                    name="email"
                    value={formData.email}
                    onChange={(e) => setFormData({...formData, email: e.target.value})}
                    placeholder="E-mail"
                    aria-errormessage={errors.email}
                    className="w-full mb-3"
                />

                <label htmlFor="password" className="block text-900 font-medium mb-2">Password</label>
                <InputText type={"password"}
                           name="password"
                           value={formData.password}
                           onChange={(e) => setFormData({...formData, password: e.target.value})}
                           placeholder="Password"
                           aria-errormessage={errors.password}
                           className="w-full mb-3"
                />
                <div style={{display: 'flex', justifyContent: 'space-between'}}>
                    <Link to={"/resetpassword"} className="font-medium no-underline text-blue-500" style={{alignSelf: 'flex-start'}}>
                        Forgot your password?
                    </Link>
                    <Button type="submit" disabled={!isFormValid}>Login</Button>
                </div>
            </Card>
        </div>
    )
}
