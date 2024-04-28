import './Table.css'

export default function Table({ tree }) {
    console.log(tree)
    console.log([...tree.folders])
    // const data = tree && tree.folders.map(folder=>(
    //     <tr>
    //         <td>{folder.id}</td>
    //         <td>{folder.name}</td>
    //         <td>{folder.dateCreated}</td>
    //     </tr>
    // ))

    return (
        <div>
            <div>Path: {tree.path}</div>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Last modified</th>
                    <th>Location</th>
                </tr>
                {/* {data} */}
            </table>
        </div>
    )
}