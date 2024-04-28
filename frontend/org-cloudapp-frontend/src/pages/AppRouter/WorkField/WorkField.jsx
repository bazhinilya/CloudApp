import './WorkField.css'
import Table from '../../../components/table/Table'
import { useEffect, useState } from 'react'
import axios from 'axios'

export default function WorkField(props) {

    const [tree, setTree] = useState({})

    useEffect(() => {
        axios.get(`http://localhost:8080/cd/1`)
            .then(response => { setTree(response.data) })
            .catch(error => { console.log(error) })
    }, [])
    // useMemo(, [folder])

    return (
        <div className='work-field'>
            <h1>{props.name}</h1>
            <Table tree={tree} />
        </div>
    )
}