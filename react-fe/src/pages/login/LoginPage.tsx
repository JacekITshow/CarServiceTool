import React, {useEffect, useState} from 'react';
import {InputText} from "primereact/inputtext";
import {Button} from "primereact/button";

export default function Home() {

    const [formData, setFormData] = useState({
        login: "",
        password: ""
    });

    const [errors, setErrors] = useState({
        login: "",
        password: ""
    });

    const [isFormValid, setIsFormValid] = useState(false);

    useEffect(() => {
    const validateForm = () => {
        let isValid = true;
        const newErrors: {login: string, password: string} = {
            login: '',
            password: ''
        };

        if (!formData.login) {
            isValid = false;
            newErrors.login = "Pole 'Login' jest wymagane";
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
            <div className="col-8 grid">
                <div className="col-12 md:col-6 lg:col-3">
                    <form onSubmit={handleSubmit}>
                        <InputText
                            name="login"
                            value={formData.login}
                            onChange={(e) => setFormData({...formData, login: e.target.value})}
                            placeholder="Login"
                            aria-errormessage={errors.login}
                        />
                        <InputText
                            name="login"
                            value={formData.login}
                            onChange={(e) => setFormData({...formData, login: e.target.value})}
                            placeholder="Login"
                            aria-errormessage={errors.login}
                        />

                        <Button type="submit" disabled={!isFormValid}>Zarejestruj</Button>
                    </form>
                </div>
            </div>
        </div>
    )
}
