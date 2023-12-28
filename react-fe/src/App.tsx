import React from 'react';
import logo from './logo.svg';
import './App.css';
import {PrimeReactProvider} from "primereact/api";
import {Checkbox} from "primereact/checkbox";
import {ToggleButton} from "primereact/togglebutton";

import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import 'primeflex/primeflex.css';

function App() {
    return (
        <PrimeReactProvider>
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
                        Learn React
                    </a>
                  <Checkbox checked={false}/>
                  <ToggleButton />
                </header>


            </div>
        </PrimeReactProvider>
    );
}

export default App;
