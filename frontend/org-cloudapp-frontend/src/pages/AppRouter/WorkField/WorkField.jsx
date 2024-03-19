import './WorkField.css'
import Table from '../../../components/table/Table'
import { useEffect, useMemo, useState } from 'react'
import { getDefaultFolder } from '../../../services/ApiService'

export default function WorkField(props) {

    const [folder, setFolder] = useState({})

    useEffect(async () => {
        setFolder(await getDefaultFolder('ilya'))
    }, [folder])
    // useMemo(, [folder])

    return (
        <div className='work-field'>
            <h1>{props.name}</h1>
            <Table folder={folder} />
        </div>
    )
}