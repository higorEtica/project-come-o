import React, { useEffect, useState } from 'react';
import axios from 'axios';


interface Phone {
    id: number;
    number: string;
    type: string;
}

const PhoneTable = () =>{
    const [phones, setPhones] = useState<Phone[]>([]);

    useEffect(() => {
        console.log('useEffect');
        const fetchPhones = async () =>{
            try{
                axios.get('http://localhost:8080/client/1')
                .then(res => {
                    console.log(res.data);
                    setPhones(res.data.phones);
                })

            }catch(error){
                console.log(error);
            }
        }
        fetchPhones();
    
    },[]);

    return (
        <div>
            <h2>Números de Telefone do Cliente</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Número</th>
                        <th>Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    {phones.map(phone => (
                        <tr key={phone.id}>
                            <td>{phone.id}</td>
                            <td>{phone.number}</td>
                            <td>{phone.type}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};
export default PhoneTable;
