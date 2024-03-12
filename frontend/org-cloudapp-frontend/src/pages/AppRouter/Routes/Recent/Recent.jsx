import './Recent.css'
import { useEffect, useState } from 'react'
import { getAll } from '../../../../services/ApiService'
import Table from '../../../../components/table/Table'

export default function Recent() {

    const [data, setData] = useState([])
    useEffect(() => {
        getAll(0).then(response => { setData(response.data) }).catch(error => console.log(error))
    }, [])

    return (
        <div className='recent'>
            <h1>Recent file</h1>
            <Table data={data} />
        </div>)
}