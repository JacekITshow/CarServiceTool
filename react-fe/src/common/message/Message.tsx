
import React, { useRef } from 'react';
import { Button } from 'primereact/button';
import { Toast } from 'primereact/toast';


interface MyMessageProps {
    toast: React.RefObject<Toast>;
}

export const Message = (props : MyMessageProps) => {

    const show = () => {
        props.toast.current?.show({ severity: 'success', summary: 'Success', detail: 'Message work correctly', life: 1000 });
        props.toast.current?.show({ severity: 'success', summary: 'Success', detail: 'Message work correctly', life: 10000 });
    };

    return (
        <div className="card flex justify-content-center">
            <Toast ref={props.toast} />
            <Button onClick={show} label="Show" />
        </div>
    )
}
