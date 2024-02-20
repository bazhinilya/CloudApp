import { Link } from 'react-router-dom'
import { routes } from '../routes/routes'

export default function Sidebar() {
    return <div className='sidebar'>
        Sidebar
        <div className='sidebar__links'>
            {
                routes.map(route =>
                    <Link to={route.path}>
                        <div className='sidebar__links__link'>
                            {route.name}
                        </div>
                    </Link>)
            }
        </div>
    </div>
}