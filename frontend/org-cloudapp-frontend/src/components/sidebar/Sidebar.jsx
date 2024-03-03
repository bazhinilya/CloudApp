import './Sidebar.css'
import { Link } from 'react-router-dom'
import { routes } from '../../routes/routes'

export default function Sidebar() {
    return (
        <div className='sidebar'>

            <img alt='logo' />
            <h1>CloudApp</h1>

            <div className='sidebar__links'>
                {
                    routes.map(route =>
                        <Link to={route.path} key={route.name}>
                            <div className='sidebar__links__link'>
                                {route.name}
                            </div>
                        </Link>)
                }
            </div>

        </div>
    )
}