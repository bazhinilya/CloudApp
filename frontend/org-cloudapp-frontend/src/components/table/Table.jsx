import './Table.css'

export default function Table(props) {
    const data = props.data && props.data.map(file => (
        <tr>
            <td>{file.extension.name} {file.name}</td>
            <td>{file.data}</td>
        </tr>
    ))

    return (
        <div>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Last modified</th>
                    <th>Location</th>
                </tr>
                {data}
            </table>
        </div>
    )
}