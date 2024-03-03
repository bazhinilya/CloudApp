import { useEffect, useState } from 'react'
import { getAll } from '../../../services/ApiService'

export default function Home() {
    const [dataFile, setDataFile] = useState([])
    useEffect(() => {
        getAll(0).then(response => { setDataFile(response.data) }).catch(error => console.log(error))
    }, [])

    return (
        <div className='home'>
            Home page
            {
                dataFile.map(file => <div key={file.id}>
                    <div>{file.name}</div>
                    <div>{file.byteCode}</div>
                    <div>{file.extension.name}</div>
                </div>)
            }
        </div>
    )
}