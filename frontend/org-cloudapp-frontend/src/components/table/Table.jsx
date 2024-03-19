import './Table.css'

export default function Table(props) {
    const data = props.folder && [...props.folder].map(fild => (
        <tr>
            <td>{fild.name}</td>
            <td>{fild.id}</td>
            <td>{fild.patent_id}</td>
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