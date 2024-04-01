import {PanelMenu} from 'primereact/panelmenu';
import React from 'react';
import AdministrationRouter from "./AdministrationRouter";


export default function Administration() {

    const menuItems = [
        {
            label: 'Files',
            icon: 'pi pi-file',
            url: '/administration/general'
        },
        {
            label: 'Cloud',
            icon: 'pi pi-cloud',
            items: [
                {
                    label: 'Upload',
                    icon: 'pi pi-cloud-upload'
                },
                {
                    label: 'Download',
                    icon: 'pi pi-cloud-download'
                },
                {
                    label: 'Sync',
                    icon: 'pi pi-refresh'
                }
            ]
        },
        {
            label: 'Devices',
            icon: 'pi pi-desktop',
            items: [
                {
                    label: 'Phone',
                    icon: 'pi pi-mobile'
                },
                {
                    label: 'Desktop',
                    icon: 'pi pi-desktop'
                },
                {
                    label: 'Tablet',
                    icon: 'pi pi-tablet'
                }
            ]
        }
    ];

    return (
        <div className="flex">
            <PanelMenu model={menuItems} className="w-25rem m-2"/>
            <div className="w-full bg-cyan-100 p-2">
                <AdministrationRouter />
            </div>
        </div>
    );
}
