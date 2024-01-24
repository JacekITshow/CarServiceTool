import React from 'react';
import logo from "../../logo.svg";

export default function ContactPage() {

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                    Edit <code>src/App.tsx</code> and save to reload.
                </p>
                <div className="mb-3 font-bold text-3xl">
                    <span className="text-900">One Product, </span>
                    <span className="text-blue-600">Many Solutions</span>
                </div>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Contact Page
                </a>
            </header>

        </div>
    )
}
