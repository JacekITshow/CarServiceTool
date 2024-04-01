import React from 'react';
import { Menubar } from 'primereact/menubar';
import { InputText } from 'primereact/inputtext';
import { Avatar } from 'primereact/avatar';
import {userDataDTO} from "../../AppDTO";

interface NavigationProps {
    userData: userDataDTO;
}

export default function Navigation(props: NavigationProps) {

    const items = [
        {
            label: 'Home',
            icon: 'pi pi-home',
            url: '/'
        },
        {
            label: 'Users',
            icon: 'pi pi-users',
            url: '/usersList'
        },
        {
            label: 'Cars',
            icon: 'pi pi-car',
            url: '/carsList'
        },
        {
            label: 'Calendar',
            icon: 'pi pi-calendar-times',
            url: '/calendar'
        },
        {
            label: 'Bank',
            icon: 'pi pi-wallet',
            url: '/wallet'
        },
        {
            label: 'Money',
            icon: 'pi pi-money-bill',
            url: '/wallet'
        },
        {
            label: 'Analysis',
            icon: 'pi pi-chart-pie',
            url: '/analysis'
        },
        {
            label: 'Projects',
            icon: 'pi pi-search',
            items: [
                {
                    label: 'Admin',
                    icon: 'pi pi-bolt',
                    url: '/admin'
                },
                {
                    label: 'User Settings',
                    icon: 'pi pi-user-edit',
                    url: '/userSetting'
                },
                {
                    label: 'Settings',
                    icon: 'pi pi-cog',
                    url: '/setting'
                },
                {
                    separator: true
                },
                {
                    label: 'Logout',
                    icon: 'pi pi-palette',
                    url: '/logout'
                }
            ]
        },
        {
            label: 'Contact',
            icon: 'pi pi-envelope',
            badge: 3,
            url: '/contact'
        },
        {
            label: 'Administration',
            icon: 'pi pi-palette',
            badge: 3,
            url: '/administration'
        }
    ];

    const start = <img alt="logo" src="https://primefaces.org/cdn/primereact/images/logo.png" height="40" className="mr-2"></img>;
    const end = (
        <div className="flex align-items-center gap-2">
            <InputText placeholder="Search" type="text" className="w-8rem sm:w-auto" />
            <p>{props.userData.firstName +" " + props.userData.surname}</p>
            <Avatar image="https://primefaces.org/cdn/primevue/images/avatar/amyelsner.png" shape="circle" label={props.userData.firstName +" " + props.userData.surname} />
        </div>
    );

    return (
        <div className="card">
            <Menubar model={items} start={start} end={end} />
        </div>
    )
}
