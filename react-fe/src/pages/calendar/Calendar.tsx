import React, {useState, useEffect} from 'react';
import {Card} from "primereact/card"
import './calendar.css';
import {Button} from "primereact/button";

export default function CustomCalendar() {

    // Pobierz daty od poniedziałku do niedzieli
    const getWeekDates = () => {
        const today = new Date();
        const currentDay = today.getDay();
        const startOfWeek = new Date(today);
        startOfWeek.setDate(today.getDate() - currentDay + (currentDay === 0 ? -6 : 1));

        const weekDates = [];
        for (let i = 0; i < 7; i++) {
            const date = new Date(startOfWeek);
            date.setDate(startOfWeek.getDate() + i);
            weekDates.push(date);
        }

        return weekDates;
    };

    // Funkcja do obsługi zmiany daty w kalendarzu
    const handleDateChange = (e: any) => {
        console.log('Wybrana data:', e.value);
        // Tutaj możesz umieścić kod obsługujący zmianę daty, np. pobranie zadań na daną datę
    };

    const weekDates = getWeekDates();

    const header = <h4 className={"text-center"}>Card header</h4>;

    const footer = <span>
    <Button icon="pi pi-pencil" size="small"/>
</span>;

    const columnInsert =
        <Card footer={footer} header={header}
              className={"surface-0 shadow-2 border-1 border-50 border-round overflow-breakword p-0 mb-3"}>
            ContentContentContentContentContentContentContent
            Content
            Content
            Content
            Content
            Content
            Content
        </Card>;

    return (
        <div>

            <div className={"grid justify-content-center"}>
                <div className={"col-12 xl:col-2 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Monday</h3>
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-2 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Tuesday</h3>
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-2 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Wednesday</h3>
                    <h5 className={"text-center"}>18/01/2024</h5>
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-2 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Thursday</h3>
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-2 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Friday</h3>
                    {columnInsert}
                    {columnInsert}
                </div>
            </div>
            <div className={"grid justify-content-center"}>
                <div className={"col-12 xl:col-14 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Monday</h3>
                    {columnInsert}
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-14 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Tuesday</h3>
                    {columnInsert}
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-14 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Wednesday</h3>
                    {columnInsert}
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-14 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Thursday</h3>
                    {columnInsert}
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-14 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Friday</h3>
                    {columnInsert}
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-14 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Saturday</h3>
                    {columnInsert}
                    {columnInsert}
                    {columnInsert}
                </div>
                <div className={"col-12 xl:col-14 lg:col-3 md:col-4 sm:col-6"}>
                    <h3 className={"text-center"}>Sunday</h3>
                    {columnInsert}
                    {columnInsert}
                    {columnInsert}
                </div>
            </div>
            <div className="grid justify-content-center">
                <div className="shadow-2 p-3 m-1 flex flex-column col-12 xl:col-13 lg:col-3 md:col-4 sm:col-6"
                     style={{borderRadius: '6px'}}>
                    <div className="text-900 font-medium text-xl mb-2">Enterprise</div>
                    <div className="text-600">Plan description</div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <div className="flex align-items-center">
                        <span className="font-bold text-2xl text-900">$49</span>
                        <span className="ml-2 font-medium text-600">per month</span>
                    </div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <ul className="list-none p-0 m-0 flex-grow-1">
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Arcu vitae elementum</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Dui faucibus in ornare</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Morbi tincidunt augue</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Duis ultricies lacus sed</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Imperdiet proin</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Nisi scelerisque</span>
                        </li>
                    </ul>
                    <hr className="mb-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <Button label="Buy Now" className="p-3 w-full p-button-outlined"/>
                </div>
                <div className="shadow-2 p-3 m-1 flex flex-column col-12 xl:col-13 lg:col-3 md:col-4 sm:col-6"
                     style={{borderRadius: '6px'}}>
                    <div className="text-900 font-medium text-xl mb-2">Enterprise</div>
                    <div className="text-600">Plan description</div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <div className="flex align-items-center">
                        <span className="font-bold text-2xl text-900">$49</span>
                        <span className="ml-2 font-medium text-600">per month</span>
                    </div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <ul className="list-none p-0 m-0 flex-grow-1">
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Arcu vitae elementum</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Dui faucibus in ornare</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Morbi tincidunt augue</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Duis ultricies lacus sed</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Imperdiet proin</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Nisi scelerisque</span>
                        </li>
                    </ul>
                    <hr className="mb-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <Button label="Buy Now" className="p-3 w-full p-button-outlined"/>
                </div>
                <div className="shadow-2 p-3 m-1 flex flex-column col-12 xl:col-13 lg:col-3 md:col-4 sm:col-6"
                     style={{borderRadius: '6px'}}>
                    <div className="text-900 font-medium text-xl mb-2">Enterprise</div>
                    <div className="text-600">Plan description</div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <div className="flex align-items-center">
                        <span className="font-bold text-2xl text-900">$49</span>
                        <span className="ml-2 font-medium text-600">per month</span>
                    </div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <ul className="list-none p-0 m-0 flex-grow-1">
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Arcu vitae elementum</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Dui faucibus in ornare</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Morbi tincidunt augue</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Duis ultricies lacus sed</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Imperdiet proin</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Nisi scelerisque</span>
                        </li>
                    </ul>
                    <hr className="mb-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <Button label="Buy Now" className="p-3 w-full p-button-outlined"/>
                </div>
                <div className="shadow-2 p-3 m-1 flex flex-column col-12 xl:col-13 lg:col-3 md:col-4 sm:col-6"
                     style={{borderRadius: '6px'}}>
                    <div className="text-900 font-medium text-xl mb-2">Enterprise</div>
                    <div className="text-600">Plan description</div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <div className="flex align-items-center">
                        <span className="font-bold text-2xl text-900">$49</span>
                        <span className="ml-2 font-medium text-600">per month</span>
                    </div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <ul className="list-none p-0 m-0 flex-grow-1">
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Arcu vitae elementum</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Dui faucibus in ornare</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Morbi tincidunt augue</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Duis ultricies lacus sed</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Imperdiet proin</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Nisi scelerisque</span>
                        </li>
                    </ul>
                    <hr className="mb-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <Button label="Buy Now" className="p-3 w-full p-button-outlined"/>
                </div>
                <div className="shadow-2 p-3 m-1 flex flex-column col-12 xl:col-13 lg:col-3 md:col-4 sm:col-6"
                     style={{borderRadius: '6px'}}>
                    <div className="text-900 font-medium text-xl mb-2">Enterprise</div>
                    <div className="text-600">Plan description</div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <div className="flex align-items-center">
                        <span className="font-bold text-2xl text-900">$49</span>
                        <span className="ml-2 font-medium text-600">per month</span>
                    </div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <ul className="list-none p-0 m-0 flex-grow-1">
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Arcu vitae elementum</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Dui faucibus in ornare</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Morbi tincidunt augue</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Duis ultricies lacus sed</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Imperdiet proin</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Nisi scelerisque</span>
                        </li>
                    </ul>
                    <hr className="mb-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <Button label="Buy Now" className="p-3 w-full p-button-outlined"/>
                </div>
                <div className="shadow-2 p-3 m-1 flex flex-column col-12 xl:col-13 lg:col-3 md:col-4 sm:col-6"
                     style={{borderRadius: '6px'}}>
                    <div className="text-900 font-medium text-xl mb-2">Enterprise</div>
                    <div className="text-600">Plan description</div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <div className="flex align-items-center">
                        <span className="font-bold text-2xl text-900">$49</span>
                        <span className="ml-2 font-medium text-600">per month</span>
                    </div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <ul className="list-none p-0 m-0 flex-grow-1">
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Arcu vitae elementum</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Dui faucibus in ornare</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Morbi tincidunt augue</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Duis ultricies lacus sed</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Imperdiet proin</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Nisi scelerisque</span>
                        </li>
                    </ul>
                    <hr className="mb-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <Button label="Buy Now" className="p-3 w-full p-button-outlined"/>
                </div>
                <div className="shadow-2 p-3 m-1 flex flex-column col-12 xl:col-13 lg:col-3 md:col-4 sm:col-6"
                     style={{borderRadius: '6px'}}>
                    <div className="text-900 font-medium text-xl mb-2">Enterprise</div>
                    <div className="text-600">Plan description</div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <div className="flex align-items-center">
                        <span className="font-bold text-2xl text-900">$49</span>
                        <span className="ml-2 font-medium text-600">per month</span>
                    </div>
                    <hr className="my-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <ul className="list-none p-0 m-0 flex-grow-1">
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Arcu vitae elementum</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Dui faucibus in ornare</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Morbi tincidunt augue</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Duis ultricies lacus sed</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Imperdiet proin</span>
                        </li>
                        <li className="flex align-items-center mb-3">
                            <i className="pi pi-check-circle text-green-500 mr-2"></i>
                            <span>Nisi scelerisque</span>
                        </li>
                    </ul>
                    <hr className="mb-3 mx-0 border-top-1 border-bottom-none border-300"/>
                    <Button label="Buy Now" className="p-3 w-full p-button-outlined"/>
                </div>
            </div>
        </div>
    );
}
